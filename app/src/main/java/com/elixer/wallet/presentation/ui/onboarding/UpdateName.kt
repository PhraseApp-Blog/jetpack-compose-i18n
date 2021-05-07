package com.elixer.wallet.presentation.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elixer.wallet.R

@Composable
fun UpdateName(
    navigateToDashboard: () -> Unit,
    decreasePageCount: () -> Unit,
    name: MutableState<String>
) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Surface(
            color = Color.DarkGray, modifier = Modifier
                .weight(7f)
                .fillMaxWidth(),
            shape = RoundedCornerShape(30.dp).copy(
                topStart = ZeroCornerSize,
                topEnd = ZeroCornerSize
            )
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(10.dp)
            ) {

                Spacer(modifier = Modifier.height(50.dp))
                Image(
                    painter = painterResource(R.drawable.bank_note),
                    contentDescription = stringResource(R.string.image_description_bank_not),
                    Modifier
                        .height(100.dp)
                        .width(100.dp)
                )
                Text(
                    text = stringResource(id = R.string.enter_name),
                    style = MaterialTheme.typography.body1,
                    color = Color.White
                )
                OutlinedTextField(
                    value = name.value,
                    onValueChange = { name.value = it },
                    textStyle = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                    ),
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.height(50.dp))
            }

        }
        Spacer(modifier = Modifier.height(50.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(3f)
        ) {
            Button(onClick = decreasePageCount) {
                Text(
                    text = stringResource(id = R.string.button_back),
                    style = MaterialTheme.typography.h6
                )
            }
            Spacer(modifier = Modifier.padding(60.dp))
            Button(onClick = navigateToDashboard) {
                Text(
                    text = stringResource(id = R.string.button_next),
                    style = MaterialTheme.typography.h6
                )
            }
        }
    }
}