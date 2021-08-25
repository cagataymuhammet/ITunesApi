package com.turkcell.digitalBrand.util.recyclerView

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class TMarginItemDecoration(private val spaceHeight: Int) : RecyclerView.ItemDecoration() {

    private var mOrientation = TDividerItemDecoration.VERTICAL

    fun setOrientation(orientation: Int) {
        require(!(orientation != TDividerItemDecoration.HORIZONTAL && orientation != TDividerItemDecoration.VERTICAL)) { "Invalid orientation. It should be either HORIZONTAL or VERTICAL" }
        mOrientation = orientation
    }

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) == 0) {
                top = spaceHeight
            }
            if (mOrientation == TDividerItemDecoration.VERTICAL) {
                bottom = spaceHeight
            } else {

                left = spaceHeight
                right = spaceHeight
            }


        }
    }
}