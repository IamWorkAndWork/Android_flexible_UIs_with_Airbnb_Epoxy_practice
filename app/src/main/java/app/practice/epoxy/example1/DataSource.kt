package app.practice.epoxy.example1

import app.practice.epoxy.example1.models.CarouselItemModel
import app.practice.epoxy.example1.models.TaskModel

object DataSource {

    val taskList = mutableListOf<TaskModel>(
        TaskModel("id1", "Audio & Video", 4),
        TaskModel("id2", "Updating", 6),
        TaskModel("id3", "Drink and food", 2),
        TaskModel("id4", "Security", 4),
        TaskModel("id5", "Dark theme     ", 6),
    )

    val carouselItems = listOf(
        CarouselItemModel("id11", "Event problems", "Call issue center"),
        CarouselItemModel("id21", "Emergency", "Call policy"),
        CarouselItemModel("id31", "Tassk 4", "Call google"),
        CarouselItemModel("id32", "Tassk 5", "Call google2"),
        CarouselItemModel("id33", "Tassk 6", "Call google3"),
    )

}