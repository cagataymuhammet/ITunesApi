package com.cagataymuhammet.itunesapi.ui.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.cagataymuhammet.itunesapi.data.model.SearchResponse
import com.cagataymuhammet.itunesapi.util.MainCoroutineScopeRule
import com.cagataymuhammet.itunesapi.util.constants.EntitiyType
import com.cagataymuhammet.itunesapi.util.constants.Resource
import com.cagataymuhammet.itunesapi.util.getOrAwaitValue
import com.google.common.truth.Truth
import com.medipol.medipolhafat11mvvm.data.repository.SearchRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

@ExperimentalCoroutinesApi
class SearchViewModelTest {

    lateinit var viewModel: SearchViewModel

    @get:Rule
    val testInstantRule: TestRule = InstantTaskExecutorRule()

    @get: Rule
    var mainCoroutineRule = MainCoroutineScopeRule()

    @MockK
    lateinit var repository: SearchRepository

    private val exceptionMockData = mockk<Exception>(relaxed = true)
    private val searchResponseMockData = mockk<SearchResponse>(relaxed = true)

    private val term = "apl"
    private val entity = EntitiyType.ALL.value.enumValue

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = SearchViewModel(repository)
    }

    @Test
    fun `when network request is sucesss`() {
        //GIVEN
        coEvery {
            repository.doSearch(term, entity)
        } returns flow {
            emit(Resource.Success(searchResponseMockData))
        }

        //WHEN
        viewModel.doSearch(term, entity)

        Truth.assertThat(viewModel.searchResponseLiveData.getOrAwaitValue())
            .isEqualTo(searchResponseMockData)
    }


    @Test
    fun `when network request is loading`() {

        //GIVEN
        coEvery {
            repository.doSearch(term, entity)
        } returns flow {
            emit(Resource.Loading(true))
        }

        //WHEN
        viewModel.doSearch(term, entity)

        //THEN
        Truth.assertThat(viewModel.isLoading.getOrAwaitValue()).isEqualTo(true)
    }

    @Test
    fun `when network request throws exception`() {

        //GIVEN
        coEvery {
            repository.doSearch(term, entity)
        } returns flow {
            emit(Resource.Error(exceptionMockData))
        }

        //WHEN
        viewModel.doSearch(term, entity)

        //THEN
        Truth.assertThat(viewModel.exceptionLiveData.getOrAwaitValue()).isEqualTo(exceptionMockData)
    }

}