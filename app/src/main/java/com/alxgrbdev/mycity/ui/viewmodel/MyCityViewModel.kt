package com.alxgrbdev.mycity.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.alxgrbdev.mycity.data.Category
import com.alxgrbdev.mycity.data.PageType
import com.alxgrbdev.mycity.data.Recommendation
import com.alxgrbdev.mycity.data.local.LocalCategoryDataProvider
import com.alxgrbdev.mycity.data.local.LocalRecommendationDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MyCityUiState())
    val uiState: StateFlow<MyCityUiState> = _uiState

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        val categories = LocalCategoryDataProvider.allCategories
        val recommendations = LocalRecommendationDataProvider.allRecommendations
        _uiState.value =
            MyCityUiState(
                categories = categories,
                recommendations = recommendations
            )
    }

    fun updateDetailsScreenStates(recommendation: Recommendation) {
        _uiState.update {
            it.copy(
                currentSelectedRecommendation = recommendation,
                showingPage = PageType.DetailsPage
            )
        }
    }

    fun changeHomeScreenStates(pageType: PageType) {
        _uiState.update {
            it.copy(
                showingPage = pageType
            )
        }
    }

    fun updateRecommendationScreenStates(category: Category) {
        _uiState.update { it ->
            it.copy(
                recommendations = LocalRecommendationDataProvider.allRecommendations
                    .filter { recommendation -> recommendation.type == category.categoryType },
                currentSelectedCategory = category,
                showingPage = PageType.RecommendationsPage
            )
        }
    }
}