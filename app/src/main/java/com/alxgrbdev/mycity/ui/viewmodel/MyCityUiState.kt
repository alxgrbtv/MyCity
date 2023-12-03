package com.alxgrbdev.mycity.ui.viewmodel

import com.alxgrbdev.mycity.data.Recommendation
import com.alxgrbdev.mycity.data.local.LocalRecommendationDataProvider

data class MyCityUiState(
    val recommendations: List<Recommendation> = emptyList(),
    val currentSelectedRecommendation: Recommendation = LocalRecommendationDataProvider.defaultRecommendation,
    val isShowingHomepage: Boolean = true
)