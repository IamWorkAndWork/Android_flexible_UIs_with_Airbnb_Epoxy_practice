package app.practice.epoxy

import com.airbnb.epoxy.EpoxyDataBindingLayouts
import com.airbnb.epoxy.EpoxyDataBindingPattern

//@EpoxyDataBindingLayouts(
//    R.layout.example1_item_title,
////    R.layout.example1_item_task,
////    R.layout.example1_item_task_carousel
//)
@EpoxyDataBindingPattern(
    rClass = R::class, layoutPrefix = "example1"
)
interface EpoxyConfig {
}