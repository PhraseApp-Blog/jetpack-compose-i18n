package com.elixer.wallet.presentation.ui.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.elixer.wallet.R

@Composable
fun TermsAndConditions(increasePageCount: () -> Unit) {
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

                Spacer(modifier = Modifier.height(10.dp))

                Text(
//                    text = "Terms And Conditions",
                    text = stringResource(R.string.terms_and_conditions),
                    style = MaterialTheme.typography.h4,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
                //Add vertical scroll modifier to the Html.kt Composable.
                Text(
                    modifier = Modifier.verticalScroll(rememberScrollState()),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    text = stringResource(R.string.lorem_ipso),
                    style = MaterialTheme.typography.body1,
                )
                Spacer(modifier = Modifier.height(50.dp))
            }

        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .weight(3f)
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally,) {

                Button(onClick = increasePageCount) {
                    Text(
                        text = stringResource(R.string.i_agree),
                        style = MaterialTheme.typography.h6
                    )
                }

                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    text = stringResource(R.string.landing_url),
                    style = MaterialTheme.typography.body1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }
}
