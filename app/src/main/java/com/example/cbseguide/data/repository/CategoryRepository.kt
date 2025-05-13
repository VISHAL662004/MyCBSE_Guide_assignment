// File location: app/src/main/java/com/example/cbseguide/data/repository/CategoryRepository.kt
package com.example.cbseguide.data.repository

import com.example.cbseguide.data.api.RetrofitInstance
import com.example.cbseguide.data.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryRepository {

    /**
     * Fetches categories from API and returns as List<Category>
     * Handles network exceptions by returning empty list
     */
    suspend fun getCategories(): List<Category> {
        return try {
            // Switch to IO thread for network operation
            withContext(Dispatchers.IO) {
                // Get API response through Retrofit
                val response = RetrofitInstance.api.getCategories()

                // Return categories list from response
                response.categories
            }
        } catch (e: Exception) {
            // Handle network errors (e.g., no internet, server down)
            emptyList()
        }
    }
}
