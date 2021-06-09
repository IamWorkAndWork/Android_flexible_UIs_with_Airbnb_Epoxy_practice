package app.practice.epoxy.example3

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import app.practice.epoxy.example3.reposiptry.FakeRepository
import app.practice.epoxy.example3.reposiptry.model.UIModel
import app.practice.epoxy.example3.reposiptry.model.User
import kotlinx.coroutines.flow.Flow

class Example3ViewModel(private val repository: FakeRepository) : ViewModel() {

    fun getPagingData(): Flow<PagingData<UIModel>> {
        return repository.execute()
            .cachedIn(viewModelScope)
    }

    class Factory(private val repository: FakeRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return Example3ViewModel(repository) as T
        }

    }
}