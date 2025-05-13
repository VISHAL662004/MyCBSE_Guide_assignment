// 1. Required imports
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.cbseguide.data.model.Category
import com.example.cbseguide.data.repository.CategoryRepository
import kotlinx.coroutines.launch

// 2. ViewModel class declaration
class CategoryViewModel : ViewModel() {

    // 3. Initialize Repository
    private val repository = CategoryRepository()

    // 4. State variables - must be accessible to UI but protect setters
    var categories by mutableStateOf<List<Category>>(emptyList())
        private set  // Restrict write access to ViewModel only

    var isLoading by mutableStateOf(false)
        private set  // Restrict write access to ViewModel only

    // 5. Initialization block
    init {
        loadCategories()
    }

    // 6. Data loading function - keep public for refresh functionality
    fun loadCategories() {
        viewModelScope.launch {  // Coroutine tied to ViewModel lifecycle
            try {
                isLoading = true
                categories = repository.getCategories()
            } catch (e: Exception) {
                // Handle errors (optional)
                categories = emptyList()
            } finally {
                isLoading = false
            }
        }
    }
}

