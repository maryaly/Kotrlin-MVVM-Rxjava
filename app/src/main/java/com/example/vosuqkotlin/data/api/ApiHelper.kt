package com.example.vosuqkotlin.data.api

class ApiHelper (private val apiService: ApiService) {

    fun getItems() = apiService.getItems()

}