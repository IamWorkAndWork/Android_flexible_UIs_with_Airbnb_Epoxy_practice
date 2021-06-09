package app.practice.epoxy.example3.di

import app.practice.epoxy.example3.api.FakeService
import app.practice.epoxy.example3.api.FakeServiceImpl
import app.practice.epoxy.example3.reposiptry.FakeRepository
import app.practice.epoxy.example3.reposiptry.FakeRepositoryImpl

object Injector {

    fun provideFakeApi(): FakeService {
        return FakeServiceImpl()
    }

    fun provideFakeRepository(fakeService: FakeService): FakeRepository {
        return FakeRepositoryImpl(fakeService)
    }

}