package com.alxgrbdev.mycity.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alxgrbdev.mycity.data.Recommendation
import com.alxgrbdev.mycity.ui.viewmodel.MyCityUiState

@Composable
fun MyCityHomeScreen(
    myCityUiState: MyCityUiState,
    onRecommendationItemClick: (Recommendation) -> Unit,
    onDetailScreenBackPressed: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (myCityUiState.isShowingHomepage) {
        ListOnlyContent(
            myCityUiState = myCityUiState,
            onRecommendationItemClick = onRecommendationItemClick,
            modifier = modifier
        )
    } else {
        RecommendationDetailsContent(
            myCityUiState = myCityUiState,
            onBackPressed = onDetailScreenBackPressed,
            modifier = modifier
        )
    }
}