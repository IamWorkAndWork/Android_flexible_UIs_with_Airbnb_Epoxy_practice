package app.practice.epoxy.example3.epoxy

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import app.practice.epoxy.R
import app.practice.epoxy.databinding.Example3ItemFooterBinding
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class Example3FooterEpoxy @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    val binding = DataBindingUtil.inflate<Example3ItemFooterBinding>(
        LayoutInflater.from(context), R.layout.example3_item_footer, this, true
    )

    @ModelProp
    fun setFooterText(text: String) {
        binding.footerTextView.text = text
    }

}