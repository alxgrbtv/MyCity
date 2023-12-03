package com.alxgrbdev.mycity.data.local

import com.alxgrbdev.mycity.R
import com.alxgrbdev.mycity.data.CategoryType
import com.alxgrbdev.mycity.data.Recommendation

object LocalRecommendationDataProvider {
    val defaultRecommendation = Recommendation(
        id = -1
    )

    val allRecommendations = listOf(
        Recommendation(
            id = 0,
            title = R.string.recommendation_1,
            details = R.string.place_details,
            image = R.drawable.ph_600_400,
            type = CategoryType.Category1
        ),
        Recommendation(
            id = 1,
            title = R.string.recommendation_2,
            details = R.string.place_details,
            image = R.drawable.ph_600_400,
            type = CategoryType.Category2
        ),
        Recommendation(
            id = 2,
            title = R.string.recommendation_3,
            details = R.string.place_details,
            image = R.drawable.ph_600_400,
            type = CategoryType.Category3
        ),
        Recommendation(
            id = 3,
            title = R.string.recommendation_4,
            details = R.string.place_details,
            image = R.drawable.ph_600_400,
            type = CategoryType.Category4
        ),
        Recommendation(
            id = 4,
            title = R.string.recommendation_5,
            details = R.string.place_details,
            image = R.drawable.ph_600_400,
            type = CategoryType.Category4
        ),
        Recommendation(
            id = 5,
            title = R.string.recommendation_6,
            details = R.string.place_details,
            image = R.drawable.ph_600_400,
            type = CategoryType.Category2
        ),
        Recommendation(
            id = 6,
            title = R.string.recommendation_7,
            details = R.string.place_details,
            image = R.drawable.ph_600_400,
            type = CategoryType.Category1
        ),
        Recommendation(
            id = 7,
            title = R.string.recommendation_8,
            details = R.string.place_details,
            image = R.drawable.ph_600_400,
            type = CategoryType.Category1
        )
    )
}
