package app.practice.epoxy.example2.epoxy

import android.widget.ImageView
import android.widget.TextView
import app.practice.epoxy.R
import app.practice.epoxy.example2.KotlinEpoxyHolder
import app.practice.epoxy.example2.models.Product
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide

@EpoxyModelClass(layout = R.layout.example2_row_product_item)
abstract class ProductItemEpoxy : EpoxyModelWithHolder<Holder>() {

    @EpoxyAttribute
    lateinit var product: Product

    override fun bind(holder: Holder) {

        with(holder) {
            Glide.with(productImage)
                .load(product.image)
                .centerCrop()
                .placeholder(R.color.colorPrimary)
                .into(productImage)

            productName.text = product.name
            productPrice.text = "%.2f THB".format(product.price)

        }
    }

}

class Holder : KotlinEpoxyHolder() {
    val productImage by bind<ImageView>(R.id.imageViewProductImage)
    val productName by bind<TextView>(R.id.textViewProductName)
    val productPrice by bind<TextView>(R.id.textViewProductPrice)
}