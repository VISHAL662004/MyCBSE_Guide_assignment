// 1. Package declaration (auto-generated)
package com.example.cbseguide

// 2. Required imports
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.cbseguide.presentation.ui.HomeScreen
import com.example.cbseguide.ui.theme.CBSEGuideAppTheme
import com.example.cbseguide.presentation.theme.CBSEGuideAppTheme

// 3. Main Activity class
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 4. Set Compose content
        setContent {
            // 5. Apply custom theme
            CBSEGuideAppTheme {
                // 6. Surface provides basic material design container
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = androidx.compose.material3.MaterialTheme.colorScheme.background
                ) {
                    // 7. Display HomeScreen composable
                    HomeScreen()
                }
            }
        }
    }
}
