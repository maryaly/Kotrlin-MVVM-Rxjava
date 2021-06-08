package com.example.vosuqkotlin.data.api

import com.example.vosuqkotlin.data.model.Item
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Single

class ApiServiceImpl  : ApiService {

    override fun getItems(): Single<List<Item>> {
        return Rx2AndroidNetworking.get("https://api.didex.com/api/Public/Symbol")
            .build()
            .getObjectListSingle(Item::class.java)
    }

}