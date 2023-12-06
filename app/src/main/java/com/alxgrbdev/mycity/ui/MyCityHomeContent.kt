package com.alxgrbdev.mycity.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alxgrbdev.mycity.data.Category
import com.alxgrbdev.mycity.data.PageType
import com.alxgrbdev.mycity.data.Recommendation
import com.alxgrbdev.mycity.data.local.LocalRecommendationDataProvider
import com.alxgrbdev.mycity.ui.viewmodel.MyCityUiState

@Composable
fun RecommendationDetailsContent(
    myCityUiState: MyCityUiState,
    onBackPressed: (PageType) -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onBackPressed(PageType.RecommendationsPage)
    }
    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = myCityUiState.currentSelectedRecommendation.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            Text(
                text = stringResource(id = myCityUiState.currentSelectedRecommendation.title),
                style = MaterialTheme.typography.displaySmall
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(id = myCityUiState.currentSelectedRecommendation.details),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun ListOnlyCategoriesContent(
    myCityUiState: MyCityUiState,
    onCategoryItemClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    val categories = myCityUiState.categories

    LazyColumn(
        modifier = modifier
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories, key = { category -> category.categoryType }) { category ->
            CategoryListItem(
                category = category,
                selected = false,
                onCardClick = { onCategoryItemClick(category) }
            )
        }
    }
}

@Composable
fun ListOnlyRecommendationsContent(
    myCityUiState: MyCityUiState,
    onRecommendationItemClick: (Recommendation) -> Unit,
    onBackPressed: (PageType) -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler {
        onBackPressed(PageType.CategoriesPage)
    }

    val recommendations = myCityUiState.recommendations

    LazyColumn(
        modifier = modifier
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(recommendations, key = { recommendations -> recommendations.id }) { recommendation ->
            RecommendationListItem(
                recommendation = recommendation,
                selected = false,
                onCardClick = { onRecommendationItemClick(recommendation) }
            )
        }
    }
}

@Composable
fun ListAndDetailContent(
    myCityUiState: MyCityUiState,
    onRecommendationItemClick: (Recommendation) -> Unit,
    onBackPressed: (PageType) -> Unit,
    modifier: Modifier
) {
    Row {
        // TODO: Fix onBackPressed navigation for extended screen
        ListOnlyRecommendationsContent(
            myCityUiState = myCityUiState,
            onRecommendationItemClick = onRecommendationItemClick,
            onBackPressed = onBackPressed,
            modifier = modifier
                .weight(1f)
        )
        RecommendationDetailsContent(
            myCityUiState = myCityUiState,
            onBackPressed = onBackPressed,
            modifier = modifier
                .weight(2f)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryListItem(
    category: Category,
    selected: Boolean,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = if (selected) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                MaterialTheme.colorScheme.secondaryContainer
            }
        ),
        onClick = onCardClick
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Image(
                painter = painterResource(id = category.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(96.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = stringResource(id = category.title),
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendationListItem(
    recommendation: Recommendation,
    selected: Boolean,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = if (selected) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                MaterialTheme.colorScheme.secondaryContainer
            }
        ),
        onClick = onCardClick
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Image(
                painter = painterResource(id = recommendation.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = stringResource(id = recommendation.title),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview
@Composable
fun RecommendationListItemPreview() {
    RecommendationListItem(
        recommendation = LocalRecommendationDataProvider.allRecommendations[0],
        selected = false,
        onCardClick = { /*TODO*/ }
    )
}