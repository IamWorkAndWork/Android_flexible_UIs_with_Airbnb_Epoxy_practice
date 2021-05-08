package app.practice.epoxy.example2.epoxy

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import app.practice.epoxy.R
import app.practice.epoxy.databinding.Example2RowImageRatioBinding
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.bumptech.glide.Glide

//@ModelView(defaultLayout = R.layout.example2_row_image_ratio, fullSpan = false)
@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT, fullSpan = false)
class BannerEpoxy @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var binding: Example2RowImageRatioBinding =
        DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.example2_row_image_ratio,
            this,
            true
        )

    @ModelProp
    fun setImageUrl(imageUrl: String?) {
        println("testtesttest imageUrl = $imageUrl")

        Glide.with(context)
            .load(imageUrl)
            .centerCrop()
            .placeholder(R.color.purple_500)
            .into(binding.imageViewBanner)
    }

    @CallbackProp
    fun clickListener(listener: OnClickListener?) {
        setOnClickListener(listener)
    }

}