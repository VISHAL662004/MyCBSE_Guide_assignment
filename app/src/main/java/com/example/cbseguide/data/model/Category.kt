package com.example.cbseguide.data.model

import com.google.gson.annotations.SerializedName

data class Category(
    val id: Int,
    val name: String,
    val weight: Int,
    val parent: Int?, // nullable, as it can be null
    @SerializedName("web_logo") val webLogo: String,
    @SerializedName("mobile_logo") val mobileLogo: String
)
