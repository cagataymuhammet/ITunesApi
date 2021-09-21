package com.cagataymuhammet.itunesapi.ui.search.search

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.paging.PagedList
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.cagataymuhammet.itunesapi.R
import com.cagataymuhammet.itunesapi.SearchNavigationDirections
import com.cagataymuhammet.itunesapi.data.model.SearchResult
import com.cagataymuhammet.itunesapi.databinding.FragmentSearchBinding
import com.cagataymuhammet.itunesapi.ui.base.BaseBindingFragment
import com.cagataymuhammet.itunesapi.ui.search.SearchViewModel
import com.cagataymuhammet.itunesapi.util.constants.EntitiyType
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class SearchFragment : BaseBindingFragment<FragmentSearchBinding>() {

    private val mViewModel: SearchViewModel by viewModels()

    @Inject
    lateinit var searchPaggedListAdapter: SearchPaggedListAdapter

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.search_menu, menu)
        val searchItem: MenuItem = menu.findItem(R.id.menu_search)

        (searchItem.getActionView() as SearchView).apply {

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    lastQuery = query
                    doSerch()
                    return true
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    lastQuery = query
                    doSerch()
                    return true
                }
            })
        }

        super.onCreateOptionsMenu(menu, inflater)
    }

    fun doSerch() {
        lastQuery?.apply {
            if (length > 2) {
                mViewModel.apply {
                    doSearch(lastQuery!!, selectedEntityType?.value?.enumValue)
                }
            }
        }
    }

    override fun getContentLayoutResId() = R.layout.fragment_search


    private fun checkAll() {
        mBinding?.apply {

            segmentedButtons.apply {
                check(R.id.allButton)
            }
        }

    }

    override fun populateUI() {

        setHasOptionsMenu(true)
        initBinding()
        observers()
    }

    private fun initBinding() {
        mBinding?.apply {

            viewModel = mViewModel
            searchPaggedListAdapter.setOnItemClickListener { it ->
                findNavController().navigate(SearchNavigationDirections.actionToDetailFragment(it))
            }

            recylerViewSearch.apply {
                setAdapter(searchPaggedListAdapter)
                setItemAnimator(DefaultItemAnimator())
                setHasFixedSize(true)
                setLayoutManager(GridLayoutManager(requireContext(), 2))
            }

            segmentedButtons.apply {
                onSegmentChecked { segment ->
                    selectedEntityType = EntitiyType.findEnumTypeByText(segment.text)
                    doSerch()
                }
            }

            checkAll()
        }
    }

    private fun observers() {
        mViewModel.apply {
            searchResponsePagedLiveData.observe(
                viewLifecycleOwner,
                object : Observer<PagedList<SearchResult>> {
                    override fun onChanged(t: PagedList<SearchResult>?) {
                        searchPaggedListAdapter.submitList(t)
                    }
                })
        }
    }

    companion object {
        var selectedEntityType: EntitiyType? = EntitiyType.ALL
        var lastQuery: String? = ""
    }

}