package com.alxgrbdev.mycity.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alxgrbdev.mycity.data.Category
import com.alxgrbdev.mycity.data.PageType
import com.alxgrbdev.mycity.data.Recommendation
import com.alxgrbdev.mycity.ui.viewmodel.MyCityUiState

@Composable
fun MyCityHomeScreen(
    myCityUiState: MyCityUiState,
    onCategoryItemClick: (Category) -> Unit,
    onRecommendationItemClick: (Recommendation) -> Unit,
    onBackPressed: (PageType) -> Unit,
    modifier: Modifier = Modifier
) {
    when (myCityUiState.showingPage) {
        PageType.CategoriesPage -> {
            ListOnlyCategoriesContent(
                myCityUiState = myCityUiState,
                onCategoryItemClick = onCategoryItemClick,
                modifier = modifier
            )
        }
        PageType.RecommendationsPage -> {
            ListOnlyRecommendationsContent(
                myCityUiState = myCityUiState,
                onRecommendationItemClick = onRecommendationItemClick,
                onBackPressed = onBackPressed,
                modifier = modifier
            )
        }
        PageType.DetailsPage -> {
            RecommendationDetailsContent(
                myCityUiState = myCityUiState,
                onBackPressed = onBackPressed,
                modifier = modifier
            )
        }
    }
}