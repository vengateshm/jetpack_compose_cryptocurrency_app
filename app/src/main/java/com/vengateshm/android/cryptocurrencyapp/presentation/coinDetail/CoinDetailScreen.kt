package com.vengateshm.android.cryptocurrencyapp.presentation.coinDetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.flowlayout.FlowRow
import com.vengateshm.android.cryptocurrencyapp.common.Colors
import com.vengateshm.android.cryptocurrencyapp.presentation.coinDetail.components.CoinTag
import com.vengateshm.android.cryptocurrencyapp.presentation.coinDetail.components.TeamListItem

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.coinDetailState.value

    Box(modifier = Modifier.fillMaxSize()) {
        state.coinDetail?.let { coin ->
            LazyColumn(modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)) {
                item {
                    Row(modifier = Modifier
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = "${coin.rank}. ${coin.name} (${coin.symbol})",
                            style = MaterialTheme.typography.h5,
                            modifier = Modifier.weight(8f))
                        Text(text = if (coin.isActive) "Active" else "Inactive",
                            color = if (coin.isActive) Colors.coinActive else Colors.coinInActive,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .weight(2f),
                            fontStyle = FontStyle.Italic)
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(text = coin.description,
                        style = MaterialTheme.typography.body2)
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(text = "Tags",
                        style = MaterialTheme.typography.h5)
                    Spacer(modifier = Modifier.height(15.dp))
                    FlowRow(mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth()) {
                        coin.tags.forEach { tag ->
                            CoinTag(tag = tag)
                        }
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(text = "Team members",
                        style = MaterialTheme.typography.h5)
                }
                items(coin.team) { teamMember ->
                    TeamListItem(teamMember = teamMember,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp,
                                bottom = 10.dp,
                                end = 10.dp))
                    Divider()
                }
            }
        }

        if (state.error.isNotBlank()) {
            Text(text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(Alignment.Center))
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}