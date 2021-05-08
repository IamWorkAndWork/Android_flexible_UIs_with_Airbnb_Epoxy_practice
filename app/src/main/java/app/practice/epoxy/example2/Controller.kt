package app.practice.epoxy.example2

import app.practice.epoxy.R
import app.practice.epoxy.example2.epoxy.*
import app.practice.epoxy.example2.models.Banner
import app.practice.epoxy.example2.models.Category
import app.practice.epoxy.example2.models.Product
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController
import kotlin.properties.Delegates

class Controller : EpoxyController() {

    init {


    }

    companion object {
        private const val PADDING_IN_DP = 8
    }

    var megaBanner by Delegates.observable(null as Banner?) { property, oldValue, newValue ->
        requestModelBuild()
    }

    var horizontalBanners by Delegates.observable(emptyList<Banner>()) { property, oldValue, newValue ->
        requestModelBuild()
    }

    var categories by Delegates.observable(emptyList<Category>()) { property, oldValue, newValue ->
        requestModelBuild()
    }

    var productItems by Delegates.observable(emptyList<Product>()) { property, oldValue, newValue ->
        requestModelBuild()
    }

    override fun buildModels() {

        //megaBanner
        BannerEpoxyModel_()
            .id("MEGA_BANNER")
            .imageUrl(megaBanner?.image)
            .clickListener { model, parentView, clickedView, position ->

            }
            .addTo(this)

        //horizontal Banner
        val banners = horizontalBanners.map { banner ->
            BannerEpoxyModel_()
                .id(banner.id)
                .imageUrl(banner.image)
        }

        CarouselModel_()
            .id("HORIZONTAL_BANNER")
            .numViewsToShowOnScreen(2.4f)
            .paddingDp(PADDING_IN_DP)
            .models(banners)
            .addIf(banners.isNotEmpty(), this)

        //Category
        LabelEpoxyModel_()
            .id("CATEGORY_LABEL")
            .label(R.string.label_category)
            .addTo(this)

        GridCaroselModel_()
            .id("CATEGORY_LIST")
            .numViewsToShowOnScreen(3.2f)
            .paddingDp(PADDING_IN_DP)
            .models(
                categories.map { category ->
                    BannerEpoxyModel_()
                        .id(category.id)
                        .imageUrl(category.image)
                }
            )
            .addTo(this)

        //promotion
        LabelEpoxyModel_()
            .id("PROMOTION_LABEL")
            .label(R.string.label_promotion)
            .addTo(this)

        CarouselModel_()
            .id("PROMOTION_LIST")
            .numViewsToShowOnScreen(2.2f)
            .paddingDp(PADDING_IN_DP)
            .models(
                productItems.map { product ->
                    ProductItemEpoxy_()
                        .id(product.id)
                        .product(product)
                }
            )
            .addTo(this)

    }
}