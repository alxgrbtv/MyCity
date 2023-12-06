package com.alxgrbdev.mycity.data.local

import com.alxgrbdev.mycity.R
import com.alxgrbdev.mycity.data.Category
import com.alxgrbdev.mycity.data.CategoryType

object LocalCategoryDataProvider {
    val allCategories = listOf(
        Category(
            id = 0,
            categoryType = CategoryType.Category1,
            title = R.string.category_1,
            image = R.drawable.ph_600_400
        ),
        Category(
            id = 1,
            categoryType = CategoryType.Category2,
            title = R.string.category_2,
            image = R.drawable.ph_600_400
        ),
        Category(
            id = 2,
            categoryType = CategoryType.Category3,
            title = R.string.category_3,
            image = R.drawable.ph_600_400
        ),
        Category(
            id = 3,
            categoryType = CategoryType.Category4,
            title = R.string.category_4,
            image = R.drawable.ph_600_400
        )
    )

    val defaultCategory = allCategories[0]
}