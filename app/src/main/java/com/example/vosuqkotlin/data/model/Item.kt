package com.example.vosuqkotlin.data.model

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("symbol")
    val symbol: String = "",
    @SerializedName("baseCurrencyShortName")
    val baseCurrencyShortName: String = "",
    @SerializedName("quoteCurrencyShortName")
    val quoteCurrencyShortName: String = "",
    @SerializedName("quantityIncrement")
    val quantityIncrement: Double = 0.0,
    @SerializedName("tickSize")
    val tickSize: Double = 0.0,
    @SerializedName("takeLiquidityRate")
    val takeLiquidityRate: Double = 0.0,
    @SerializedName("provideLiquidityRate")
    val provideLiquidityRate: Double = 0.0,
    @SerializedName("feeSide")
    val feeSide: Int = 0
)