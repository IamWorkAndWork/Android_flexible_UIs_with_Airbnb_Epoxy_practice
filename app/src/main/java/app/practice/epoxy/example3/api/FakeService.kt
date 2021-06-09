package app.practice.epoxy.example3.api

import app.practice.epoxy.example3.reposiptry.model.UserResponse

interface FakeService {
    suspend fun getFakeUser(limit: Int, offset: Int): UserResponse
}