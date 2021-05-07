package com.elixer.wallet.presentation.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun WalletSummary(balance: String, expense: String, income: String) {

    Card(shape = RoundedCornerShape(15.dp)) {
        val gradient = Brush.verticalGradient(
            listOf(
                Color(0xFF9456EE), Color(0xFF8D4BEE),
                Color(0xFF6211DA), Color(0xFF540EBB), Color(0xFF420A96)
            )
        )
        val modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
        Box(
            modifier = Modifier
                .background(gradient)
                .then(modifier)
        ) {
            Column(
                Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "BALAnCE",
                    style = MaterialTheme.typography.overline,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$ $balance",
                    style = MaterialTheme.typography.h3,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "TOTAL INCOME",
                    style = MaterialTheme.typography.overline,
                    modifier = Modifier.align(Alignment.End)
                )
                Text(
                    text = income,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.align(Alignment.End)
                )
                Text(
                    text = "TOTAL EXPENSE",
                    style = MaterialTheme.typography.overline,
                    modifier = Modifier.align(Alignment.End)
                )
                Text(
                    text = expense,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.align(Alignment.End)
                )
            }
        }
    }
}