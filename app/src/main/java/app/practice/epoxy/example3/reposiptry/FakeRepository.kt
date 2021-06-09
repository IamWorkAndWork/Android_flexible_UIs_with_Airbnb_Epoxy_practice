package app.practice.epoxy.example3.reposiptry

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import app.practice.epoxy.example3.api.FakeService
import app.practice.epoxy.example3.reposiptry.model.UIModel
import app.practice.epoxy.example3.reposiptry.model.User
import kotlinx.coroutines.flow.Flow

interface FakeRepository {
    fun execute(): Flow<PagingData<UIModel>>
}

class FakeRepositoryImpl(
    private val fakeService: FakeService
) : FakeRepository {

    companion object {
        private const val NETWORK_LIMIT = 10
    }

    override fun execute(): Flow<PagingData<UIModel>> {

        val pagingConfig = PagingConfig(
            pageSize = NETWORK_LIMIT,
            enablePlaceholders = true,
            prefetchDistance = 1
        )

        val flow = Pager(
            pagingConfig
        ) {
            FakePagingSource(fakeService = fakeService)
        }.flow

        return flow

    }

}