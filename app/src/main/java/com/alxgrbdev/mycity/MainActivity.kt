package com.alxgrbdev.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.ui.Modifier
import com.alxgrbdev.mycity.ui.MyCityApp
import com.alxgrbdev.mycity.ui.theme.MyCityTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCityTheme {
                Surface {
                    val windowSize = calculateWindowSizeClass(activity = this)
                    MyCityApp(
                        windowSize = windowSize.widthSizeClass,
                        modifier = Modifier
                            .fillMaxHeight()
                    )
                }
            }
        }
    }
}