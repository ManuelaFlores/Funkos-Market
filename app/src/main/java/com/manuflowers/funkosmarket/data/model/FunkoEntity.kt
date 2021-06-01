package com.manuflowers.funkosmarket.data.model

import com.google.gson.annotations.SerializedName

data class FunkoEntity(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val imageResource: String,
    @SerializedName("description")
    val description: String
) {
    val imageURL: String
    get() = "drawable/$imageResource"
}