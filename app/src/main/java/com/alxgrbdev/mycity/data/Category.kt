package com.alxgrbdev.mycity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Category(
    val categoryType: CategoryType,
    @StringRes val title: Int,
    @DrawableRes val image: Int
)
