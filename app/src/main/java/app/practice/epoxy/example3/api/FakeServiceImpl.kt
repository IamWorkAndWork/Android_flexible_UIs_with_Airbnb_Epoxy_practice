package app.practice.epoxy.example3.api

import app.practice.epoxy.example3.reposiptry.model.*

class FakeServiceImpl : FakeService {

    override suspend fun getFakeUser(limit: Int, offset: Int): UserResponse {

        val userList = mutableListOf<UIModel>()
        var offset = offset * 10 + 1

        for (i in 0 until 10) {
            if (i == 0) {
                val header = Header(
                    offset.toString(),
                    "https://images.pexels.com/photos/1404819/pexels-photo-1404819.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
                )
                userList.add(header)
            } else if (i == 9) {
                val footer = Footer(offset.toString(), "Footer $offset")
                userList.add(footer)
            } else {
                val user = User(
                    "$offset",
                    "name $offset",
                    "https://images.pexels.com/photos/1404819/pexels-photo-1404819.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
                )
                userList.add(user)
            }
            offset++
        }

        return UserResponse(
            userList = userList
        )

    }
}