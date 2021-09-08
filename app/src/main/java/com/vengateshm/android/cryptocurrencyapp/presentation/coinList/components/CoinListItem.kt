package com.vengateshm.android.cryptocurrencyapp.presentation.coinList.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.vengateshm.android.cryptocurrencyapp.common.Colors
import com.vengateshm.android.cryptocurrencyapp.domain.model.Coin

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit,
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
        .clickable { onItemClick(coin) },
        horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.weight(8f))
        Text(
            text = if (coin.isActive) "Active" else "Inactive",
            style = MaterialTheme.typography.body2,
            color = if (coin.isActive) Colors.coinActive else Colors.coinInActive,
            textAlign = TextAlign.End,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(2f),
            fontStyle = FontStyle.Italic,
        )
    }
}