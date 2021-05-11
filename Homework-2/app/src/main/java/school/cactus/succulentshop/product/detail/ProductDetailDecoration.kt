package school.cactus.succulentshop.product.detail

import android.graphics.Rect
import android.util.Log
import android.view.View
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.resources.MaterialResources.getDimensionPixelSize
import school.cactus.succulentshop.R
import kotlin.math.log


class ProductDetailDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val spacing = view.context.resources.getDimensionPixelSize(R.dimen.item_product_detail_spacing)
        val position = parent.getChildAdapterPosition(view)
        view.layoutParams.width = view.context.resources.getDimensionPixelSize(R.dimen.item_product_related_width)
        view.minimumHeight = view.context.resources.getDimensionPixelSize(R.dimen.item_product_related_height)

        val isFirst = position == 0

        outRect.right = spacing

        outRect.bottom = spacing
        if (isFirst) { outRect.left = spacing}
    }
}