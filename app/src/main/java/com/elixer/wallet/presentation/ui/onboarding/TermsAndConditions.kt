package com.elixer.wallet.presentation.ui.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun termsAndConditions(increasePageCount: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Surface(
            color = Color.DarkGray, modifier = Modifier
                .height(600.dp)
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
                    text = "Terms And Conditions",
                    style = MaterialTheme.typography.h4,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
                //Add vertical scroll modifier to the Html.kt Composable.
                Text(
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    text = "Pellentesque diam volutpat commodo sed egestas egestas fringilla phasellus. Urna molestie at elementum eu facilisis. Amet nulla facilisi morbi tempus iaculis urna id volutpat lacus. Morbi quis commodo odio aenean sed adipiscing. Arcu dictum varius duis at consectetur lorem donec massa. Facilisis leo vel fringilla est ullamcorper eget nulla facilisi. Sed elementum tempus egestas sed sed. Sagittis nisl rhoncus mattis rhoncus urna neque viverra. Suspendisse potenti nullam ac tortor vitae. Viverra mauris in aliquam sem fringilla ut morbi tincidunt augue. Malesuada pellentesque elit eget gravida cum sociis natoque penatibus. Quis blandit turpis cursus in. At tempor commodo ullamcorper a lacus vestibulum sed arcu. Facilisis gravida neque convallis a cras semper auctor neque. Sem nulla pharetra diam sit amet nisl suscipit adipiscing. Interdum velit laoreet id donec ultrices tincidunt arcu non sodales. Vel orci porta non pulvinar neque laoreet suspendisse.\n At lectus urna duis convallis convallis tellus id interdum. Egestas maecenas pharetra convallis posuere morbi leo. Enim lobortis scelerisque fermentum dui faucibus in. Et odio pellentesque diam volutpat commodo sed egestas. Tempor orci dapibus ultrices in. Sagittis vitae et leo duis ut diam quam nulla. Quam quisque id diam vel. Egestas fringilla phasellus faucibus scelerisque eleifend. Tortor aliquam nulla facilisi cras fermentum odio. Faucibus purus in massa tempor nec feugiat nisl pretium fusce.\n" +
                            "\n" +
                            "Augue neque gravida in fermentum et sollicitudin. Ac auctor augue mauris augue. Amet justo donec enim diam vulputate. Id aliquet risus feugiat in ante metus dictum. Sodales neque sodales ut etiam sit amet nisl purus in. Amet cursus sit amet dictum sit amet justo donec. Vulputate sapien nec sagittis aliquam malesuada bibendum arcu. Non quam lacus suspendisse faucibus interdum posuere. Dui id ornare arcu odio ut. Neque viverra justo nec ultrices. Lacus sed viverra tellus in hac habitasse platea. Volutpat consequat mauris nunc congue nisi vitae suscipit tellus mauris. Amet purus gravida quis blandit turpis cursus in. Dignissim diam quis enim lobortis scelerisque fermentum dui. Leo duis ut diam quam nulla porttitor. Dolor sit amet consectetur adipiscing elit pellentesque habitant morbi. Lorem ipsum dolor sit amet consectetur adipiscing. Imperdiet proin fermentum leo vel orci porta non pulvinar neque.",
                    style = MaterialTheme.typography.body1,
                )
                Spacer(modifier = Modifier.height(50.dp))
            }

        }
        Row(verticalAlignment = Alignment.CenterVertically,) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Button(onClick = increasePageCount, modifier = Modifier.width(130.dp)) {
                    Text(
                        text = "I Agree",
                        style = MaterialTheme.typography.h6
                    )
                }

                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    text = "Visit our website https://xyz.com/ to know more.",
                    style = MaterialTheme.typography.body1,
                )
            }

        }
    }
}
