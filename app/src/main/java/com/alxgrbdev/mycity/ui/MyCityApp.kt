package com.alxgrbdev.mycity.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.alxgrbdev.mycity.ui.viewmodel.MyCityViewModel

@Composable
fun MyCityApp(
    modifier: Modifier = Modifier
) {
    val viewModel: MyCityViewModel = viewModel()
    val myCityUiState = viewModel.uiState.collectAsState().value

    MyCityHomeScreen(
        myCityUiState = myCityUiState,
        onCategoryItemClick = { viewModel.updateRecommendationScreenStates(it) },
        onRecommendationItemClick = { viewModel.updateDetailsScreenStates(it) },
        onBackPressed = { viewModel.changeHomeScreenStates(it) },
        modifier = modifier
    )
}