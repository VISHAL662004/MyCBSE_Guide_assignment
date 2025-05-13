package com.example.cbseguide.data.api

import com.example.cbseguide.data.model.ApiResponse
import com.example.cbseguide.data.model.Category
import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Interface defining the API endpoints for the CBSE Guide application
 
 */
interface ApiService {
    /**
     * Makes a GET request to fetch all categories from the server
     * @return ApiResponse object containing the list of categories
     */
    @GET("category/all/")
    suspend fun getCategories(): ApiResponse
}

/**
 * Singleton object that provides a configured Retrofit instance
 * Uses lazy initialization to create the service only when needed
 */
object RetrofitInstance {
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.mycbseguide.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
