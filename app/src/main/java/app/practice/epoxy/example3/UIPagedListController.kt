package app.practice.epoxy.example3

import app.practice.epoxy.example3.epoxy.*
import app.practice.epoxy.example3.reposiptry.model.Footer
import app.practice.epoxy.example3.reposiptry.model.Header
import app.practice.epoxy.example3.reposiptry.model.UIModel
import app.practice.epoxy.example3.reposiptry.model.User
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging3.PagingDataEpoxyController

class UIPagedListController(
    private val onLoadSuccess: (() -> Unit)?
) : PagingDataEpoxyController<UIModel>() {

    var endReached = false

    override fun buildItemModel(currentPosition: Int, item: UIModel?): EpoxyModel<*> {

        println("modelsmodelsmodelsmodelsmodels loaded : " + currentPosition + " | " + item)
        return item?.let {

            if (currentPosition == 0) {
                onLoadSuccess?.invoke()
                println("modelsmodelsmodelsmodelsmodels loaded1212 : " + currentPosition + " | " + item)
            }

            when (item) {
                is User -> {
                    Example3UserEpoxyModel_().id(currentPosition)
                        .userModel(item)
                }
                is Header -> {
                    Example3HeaderEpoxyModel_().id(currentPosition)
                        .titleText("Header ${item.id}")
                        .imageBackground(item.imageUrl)
                }
                is Footer -> {
                    Example3FooterEpoxyModel_().id(currentPosition)
                        .footerText(item.text)
                }
            }

        } ?: Example3LoadingEpoxyModel_().id(-currentPosition).text("Loading")

    }

    override fun addModels(models: List<EpoxyModel<*>>) {
        println("modelsmodelsmodelsmodelsmodels addModels : " + models.size + " | endReached = " + endReached)

        super.addModels(models)
        Example3LoadingEpoxyModel_().id("loading").text("Loading")
            .addIf(!endReached && models.isNotEmpty(), this)
    }

}