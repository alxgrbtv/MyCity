package com.alxgrbdev.mycity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.alxgrbdev.mycity.ui.MyCityApp
import com.alxgrbdev.mycity.ui.theme.MyCityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCityTheme {
                Surface {
                    // TODO: Pass windowSize argument to MyCityApp
                    MyCityApp()
                }
            }
        }
    }
}