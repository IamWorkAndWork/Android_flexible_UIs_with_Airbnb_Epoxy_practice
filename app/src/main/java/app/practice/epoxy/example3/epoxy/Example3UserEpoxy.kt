package app.practice.epoxy.example3.epoxy

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import app.practice.epoxy.R
import app.practice.epoxy.databinding.Example3ItemUserBinding
import app.practice.epoxy.example3.reposiptry.model.User
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.bumptech.glide.Glide

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT, fullSpan = false)
class Example3UserEpoxy @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    private val binding = DataBindingUtil.inflate<Example3ItemUserBinding>(
        LayoutInflater.from(context), R.layout.example3_item_user, this, true
    )

    @ModelProp
    fun setUserModel(user: User) {
        binding.nameTextView.text = user.name
        Glide.with(context)
            .load(user.image)
            .centerCrop()
            .placeholder(R.color.purple_500)
            .into(binding.iconImageView)
    }

}