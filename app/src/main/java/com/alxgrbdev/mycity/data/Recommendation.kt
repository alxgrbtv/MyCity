package com.alxgrbdev.mycity.data

import androidx.annotation.StringRes

data class Recommendation(
    val id: Int,
    @StringRes val title: Int,
    @StringRes val details: Int,
    val type: CategoryType
)
