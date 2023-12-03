package com.alxgrbdev.mycity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    val id: Int,
    val categoryType: CategoryType = CategoryType.Category1,
    @StringRes val title: Int = -1,
    @DrawableRes val image: Int = -1
)
