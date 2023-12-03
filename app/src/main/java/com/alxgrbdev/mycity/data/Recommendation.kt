package com.alxgrbdev.mycity.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Recommendation(
    val id: Int,
    @StringRes val title: Int = -1,
    @StringRes val details: Int = -1,
    @DrawableRes val image: Int = -1,
    val type: CategoryType = CategoryType.Category1
) {

}
