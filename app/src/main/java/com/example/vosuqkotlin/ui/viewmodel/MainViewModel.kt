package com.example.vosuqkotlin.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vosuqkotlin.data.model.Item
import com.example.vosuqkotlin.data.repository.MainRepository
import com.example.vosuqkotlin.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val items = MutableLiveData<Resource<List<Item>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchItems()
    }

    private fun fetchItems() {
        items.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ userList ->
                    items.postValue(Resource.success(userList))
                }, { throwable ->
                    items.postValue(Resource.error("Something Went Wrong", null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getItems(): LiveData<Resource<List<Item>>> {
        return items
    }

}