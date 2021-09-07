package com.vengateshm.android.cryptocurrencyapp.presentation.coinDetail.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.vengateshm.android.cryptocurrencyapp.data.remote.dto.TeamMember

@Composable
fun CoinTag(tag: String) {
    Box(modifier = Modifier
        .border(width = 1.dp,
            color = MaterialTheme.colors.primary,
            shape = RoundedCornerShape(100.dp))
        .padding(10.dp)) {
        Text(text = tag,
            color = MaterialTheme.colors.primary,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.body2)
    }
}

@Composable
fun TeamListItem(
    teamMember: TeamMember,
    modifier: Modifier,
) {
    Column(modifier = modifier,
        verticalArrangement = Arrangement.Center) {
        Text(text = teamMember.name,
            style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = teamMember.position,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic)
    }

}