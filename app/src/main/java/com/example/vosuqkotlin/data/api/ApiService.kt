package com.example.vosuqkotlin.data.api

import com.example.vosuqkotlin.data.model.Item
import io.reactivex.Single

interface ApiService {
    fun getItems(): Single<List<Item>>
}