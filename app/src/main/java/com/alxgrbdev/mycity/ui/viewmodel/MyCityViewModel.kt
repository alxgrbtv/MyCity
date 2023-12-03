package com.alxgrbdev.mycity.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.alxgrbdev.mycity.data.Recommendation
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
        val recommendations = LocalRecommendationDataProvider.allRecommendations
        _uiState.value =
            MyCityUiState(
                recommendations = recommendations
            )
    }

    fun updateDetailsScreenStates(recommendation: Recommendation) {
        _uiState.update {
            it.copy(
                currentSelectedRecommendation = recommendation,
                isShowingHomepage = false
            )
        }
    }

    fun resetHomeScreenStates() {
        _uiState.update {
            it.copy(
                isShowingHomepage = true
            )
        }
    }
}