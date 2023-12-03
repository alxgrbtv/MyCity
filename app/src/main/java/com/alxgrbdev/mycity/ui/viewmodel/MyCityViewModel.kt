package com.alxgrbdev.mycity.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.alxgrbdev.mycity.data.local.LocalRecommendationDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

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
}