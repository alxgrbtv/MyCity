package com.alxgrbdev.mycity.ui

import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alxgrbdev.mycity.ui.utils.MyCityContentType
import com.alxgrbdev.mycity.ui.viewmodel.MyCityViewModel

@Composable
fun MyCityApp(
    windowSize: WindowWidthSizeClass,
    modifier: Modifier = Modifier
) {
    val contentType: MyCityContentType
    val viewModel: MyCityViewModel = viewModel()
    val myCityUiState = viewModel.uiState.collectAsState().value

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            contentType = MyCityContentType.ListOnly
        }
        WindowWidthSizeClass.Medium -> {
            contentType = MyCityContentType.ListOnly
        }
        WindowWidthSizeClass.Expanded -> {
            contentType = MyCityContentType.ListAndDetail
        }
        else -> {
            contentType = MyCityContentType.ListOnly
        }
    }

    MyCityHomeScreen(
        myCityUiState = myCityUiState,
        contentType = contentType,
        onCategoryItemClick = { viewModel.updateRecommendationScreenStates(it) },
        onRecommendationItemClick = { viewModel.updateDetailsScreenStates(it) },
        onBackPressed = { viewModel.changeHomeScreenStates(it) },
        modifier = modifier
    )
}