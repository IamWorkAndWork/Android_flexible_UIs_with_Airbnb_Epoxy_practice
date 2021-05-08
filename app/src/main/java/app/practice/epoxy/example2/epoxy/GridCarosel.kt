package app.practice.epoxy.example2.epoxy

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.ModelView

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class GridCarosel @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyle: Int = 0
) : Carousel(context, attrs, defStyle) {

    override fun createLayoutManager(): LayoutManager {
        return GridLayoutManager(context, 2, RecyclerView.HORIZONTAL, false)
    }

}