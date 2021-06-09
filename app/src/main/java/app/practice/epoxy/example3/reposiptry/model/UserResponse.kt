package app.practice.epoxy.example3.reposiptry.model

data class UserResponse(
    val userList: List<UIModel>
)

sealed class UIModel()

data class User(
    val id: String,
    val name: String,
    val image: String
) : UIModel()

data class Header(val id: String, val imageUrl: String) : UIModel()

data class Footer(val id: String, val text: String) : UIModel()