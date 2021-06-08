package com.example.vosuqkotlin.data.repository

import com.example.vosuqkotlin.data.api.ApiHelper
import com.example.vosuqkotlin.data.model.Item
import io.reactivex.Single

class MainRepository (private val apiHelper: ApiHelper) {

    fun getUsers(): Single<List<Item>> {
        return apiHelper.getItems()
    }

}