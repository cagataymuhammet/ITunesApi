package com.cagataymuhammet.itunesapi.util.extentions.recyclerview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.cagataymuhammet.itunesapi.data.model.SearchResult

abstract class AbstractRecyclerBindingAdapter<ITEM> constructor(
    protected var itemList: List<ITEM>,
    private val layoutResId: Int
) : RecyclerView.Adapter<AbstractRecyclerBindingAdapter.HolderBinding>() {


    override fun getItemCount() = itemList.size

    protected open fun onItemClick(itemView: View, position: Int) {
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HolderBinding {


        val holderBinding = HolderBinding(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutResId, parent, false
            )
        )
        holderBinding.itemView.setOnClickListener {
            val adapterPosition = holderBinding.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onItemClick(holderBinding.itemView, adapterPosition)
            }
        }


        return holderBinding
    }

    override fun onBindViewHolder(holder: HolderBinding, position: Int) {
        val item = itemList[position]
        bind(holder, item, position)
        holder.bindData(item)
    }

    protected open fun bind(holder: HolderBinding, item: ITEM, position: Int) {
    }


    class HolderBinding(val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindData(data: Any?, id: Int = 1) {
            binding.setVariable(id, data)
            binding.executePendingBindings()
        }

    }



}


class GeneralBindingAdapter<ITEM>(
    items: List<ITEM>,
    layoutResId: Int,
    private val bindHolder: (holder: HolderBinding, ITEM, Int) -> Unit
) : AbstractRecyclerBindingAdapter<ITEM>(items, layoutResId) {


    constructor(
        items: List<ITEM>,
        layoutResId: Int,
        bindHolder: (holder: HolderBinding, ITEM, Int) -> Unit,
        itemClick: ITEM.(Int) -> Unit = {}
    ) : this(items, layoutResId, bindHolder) {
        this.itemClick = itemClick
    }

    private var itemClick: ITEM.(Int) -> Unit = {}

    override fun bind(holder: HolderBinding, item: ITEM, position: Int) {
        super.bind(holder, item, position)
        bindHolder(holder, item, position)
    }

    override fun onItemClick(itemView: View, position: Int) {
        itemList[position].itemClick(position)
    }
}