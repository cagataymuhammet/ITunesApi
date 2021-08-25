package com.cagataymuhammet.itunesapi.util.extentions.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


abstract class AbstractRecyclerAdapter<ITEM> constructor(
        protected var itemList: List<ITEM>,
        private val layoutResId: Int
) : RecyclerView.Adapter<AbstractRecyclerAdapter.Holder>() {


    override fun getItemCount() = itemList.size

    protected open fun onItemClick(itemView: View, position: Int) {
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): Holder {
        val view = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
        val viewHolder = Holder(view)
        val itemView = viewHolder.itemView
        itemView.setOnClickListener {
            val adapterPosition = viewHolder.adapterPosition
            if (adapterPosition != RecyclerView.NO_POSITION) {
                onItemClick(itemView, adapterPosition)
            }
        }


        return viewHolder
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = itemList[position]
        holder.itemView.bind(item, position)
    }

    protected open fun View.bind(item: ITEM, position: Int) {
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)
}


class GeneralAdapter<ITEM>(
        var items: List<ITEM>,
        layoutResId: Int,
        private val bindHolder: View.(ITEM, Int) -> Unit
) : AbstractRecyclerAdapter<ITEM>(items, layoutResId) {

    private var itemClick: ITEM.(position: Int) -> Unit = {}

    constructor(
            items: List<ITEM>,
            layoutResId: Int,
            bindHolder: View.(ITEM, Int) -> Unit,
            itemClick: ITEM.(position: Int) -> Unit = {}
    ) : this(items, layoutResId, bindHolder) {
        this.itemClick = itemClick
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.bindHolder(itemList[position], position)
    }

    override fun onItemClick(itemView: View, position: Int) {
        itemList[position].itemClick(position)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
}

