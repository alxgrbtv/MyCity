package com.alxgrbdev.mycity.ui.viewmodel

import com.alxgrbdev.mycity.data.Category
import com.alxgrbdev.mycity.data.Recommendation
import com.alxgrbdev.mycity.data.PageType
import com.alxgrbdev.mycity.data.local.LocalCategoryDataProvider
import com.alxgrbdev.mycity.data.local.LocalRecommendationDataProvider

data class MyCityUiState(
    val categories: List<Category> = emptyList(),
    val recommendations: List<Recommendation> = emptyList(),
    val currentSelectedCategory: Category = LocalCategoryDataProvider.defaultCategory,
    val currentSelectedRecommendation: Recommendation = LocalRecommendationDataProvider.defaultRecommendation,
    val showingPage: PageType = PageType.CategoriesPage
)