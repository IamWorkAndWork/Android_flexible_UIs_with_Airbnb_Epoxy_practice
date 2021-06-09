package app.practice.epoxy.example3.reposiptry

import androidx.paging.PagingSource
import androidx.paging.PagingState
import app.practice.epoxy.example3.api.FakeService
import app.practice.epoxy.example3.reposiptry.model.UIModel
import app.practice.epoxy.example3.reposiptry.model.User
import app.practice.epoxy.example3.reposiptry.model.UserResponse
import com.bumptech.glide.load.HttpException
import kotlinx.coroutines.delay
import java.io.IOException

class FakePagingSource(
    private val fakeService: FakeService
) : PagingSource<Int, UIModel>() {

    override fun getRefreshKey(state: PagingState<Int, UIModel>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UIModel> {
        return try {
            delay(1000L)

            val pageNumber = params.key ?: 0

            val data = fakeService.getFakeUser(params.loadSize, pageNumber)

            val prevKey = if (pageNumber > 0) pageNumber - 1 else null
            val nextKey = if (data.userList.isNotEmpty()) pageNumber + 1 else null

            LoadResult.Page(
                data = data.userList,
                prevKey = prevKey,
                nextKey = nextKey
            )

        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

}