package com.alxgrbdev.mycity.ui.viewmodel

import com.alxgrbdev.mycity.data.Recommendation

data class MyCityUiState(
    val recommendations: List<Recommendation> = emptyList()
)