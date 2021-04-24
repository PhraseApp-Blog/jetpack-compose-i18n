package com.elixer.wallet.presentation.ui.dashboard

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elixer.wallet.model.TYPE
import com.elixer.wallet.model.Transaction

@Composable
fun TransactionItem(transaction: Transaction) {


    Row(Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 10.dp)) {
        emoji(emojiCode = transaction.emojiCode)
        transactionInfo(transaction = transaction)
        Spacer(modifier = Modifier.weight(1f))
        val amount =
            if (transaction.type == TYPE.INCOME.toString()) "+ ${transaction.amount}" else "- ${transaction.amount}"
        Text(
            text = amount,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun emoji(emojiCode: String) {
    Box() {
        Canvas(modifier = Modifier
            .size(60.dp)
            .align(Alignment.Center), onDraw = {
            drawCircle(color = Color(0xFF302F2F))
        })
        Text(
            text = emojiCode,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center).padding(bottom = 2.dp)
        )
    }
}

@Composable
fun transactionInfo(transaction: Transaction) {

    Column( verticalArrangement = Arrangement.Center,modifier = Modifier.padding(horizontal = 10.dp) ) {
        Text(
            text = transaction.title,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Start)
        )

        Text(
            text = transaction.dateAdded.toString(),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Start)
        )

    }
}

@Preview
@Composable
fun DefaultPreview() {
    TransactionItem(transaction =
    Transaction(id = 0,title = "Car Wash", amount = 100, type = "INCOME", dateAdded = 0L,emojiCode = "🚗"))
}