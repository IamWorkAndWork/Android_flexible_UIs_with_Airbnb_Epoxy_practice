package app.practice.epoxy.example3.epoxy

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import app.practice.epoxy.R
import app.practice.epoxy.databinding.Example3ItemLoadingBinding
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView


@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT, fullSpan = false)
class Example3LoadingEpoxy @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding = DataBindingUtil.inflate<Example3ItemLoadingBinding>(
        LayoutInflater.from(context), R.layout.example3_item_loading, this, true
    )

    @ModelProp
    fun setText(loadingText: String) {
        binding.loadingTextView.text = loadingText
    }

}