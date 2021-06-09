package app.practice.epoxy.example3.epoxy

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import app.practice.epoxy.R
import app.practice.epoxy.databinding.Example3ItemHeaderBinding
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.bumptech.glide.Glide

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT, fullSpan = false)
class Example3HeaderEpoxy @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private val binding = DataBindingUtil.inflate<Example3ItemHeaderBinding>(
        LayoutInflater.from(context), R.layout.example3_item_header, this, true
    )

    @ModelProp
    fun setTitleText(text: String) {
        binding.titleTextView.text = text
    }

    @ModelProp
    fun setImageBackground(imageUrl: String) {
        Glide.with(context)
            .load(imageUrl)
            .centerCrop()
            .placeholder(R.color.purple_500)
            .into(binding.backgroundImageView)
    }

}