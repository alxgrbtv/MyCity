package com.alxgrbdev.mycity.ui.viewmodel

import com.alxgrbdev.mycity.data.CategoryType
import com.alxgrbdev.mycity.data.Recommendation

data class MyCityUiState(
    val categories: Map<CategoryType, List<Recommendation>> = emptyMap()
    // TODO: Extend UI state data
)