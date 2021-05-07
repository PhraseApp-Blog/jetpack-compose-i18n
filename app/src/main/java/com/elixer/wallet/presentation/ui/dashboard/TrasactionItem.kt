package com.elixer.wallet.presentation.ui.dashboard

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elixer.wallet.model.TYPE
import com.elixer.wallet.model.Transaction
import java.text.NumberFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Composable
fun TransactionItem(transaction: Transaction) {


    Row(
//        horizontalArrangement = Arrangement.,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        emoji(emojiCode = transaction.emojiCode)

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            //Evenly add space between the components
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            transactionInfo(transaction = transaction)
            val amount = if (transaction.type.equals(TYPE.INCOME)) transaction.amount else transaction.amount.unaryMinus()
            val formattedAmount = NumberFormat.getInstance().format(amount);
            Text(
                text = formattedAmount,
                fontSize = 20.sp,
                textAlign = TextAlign.End,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

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
            modifier = Modifier
                .align(Alignment.Center)
                .padding(bottom = 2.dp)
        )
    }
}

@Composable
fun transactionInfo(transaction: Transaction) {

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(horizontal = 10.dp)
            //This will set a max width of this column to be 70% of the parent
            .fillMaxSize(0.7f)
    ) {
        Text(
            text = transaction.title,
            fontSize = 18.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier.align(Alignment.Start),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis

        )
        val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)
        val transactionDate: LocalDate = LocalDate.ofEpochDay(transaction.dateAdded / 86400000L)
        val formattedTransactionDate: String = transactionDate.format(dateFormatter)

        Text(
            text = formattedTransactionDate,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Start),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

    }
}

@Preview
@Composable
fun DefaultPreview() {
    TransactionItem(
        transaction =
        Transaction(
            id = 0,
            title = "Car Wash",
            amount = 100,
            type = "INCOME",
            dateAdded = 0L,
            emojiCode = "🚗"
        )
    )
}