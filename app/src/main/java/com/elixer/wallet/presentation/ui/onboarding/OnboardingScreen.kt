
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elixer.wallet.R
import com.elixer.wallet.presentation.navigation.Screen
import com.elixer.wallet.presentation.theme.WalletTheme
import com.elixer.wallet.presentation.ui.onboarding.OnboardingViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun OnBoardingScreen(viewModel: OnboardingViewModel,  onNavigateToDashboardScreen: (String) -> Unit,) {

    val screenNumber = remember { mutableStateOf(0) }
    var name = remember { mutableStateOf("") }


    WalletTheme() {

        Box {
            Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {}
            fun increasePageNumber() {
                screenNumber.value += 1
            }

            fun decreasePageNumber() {
                screenNumber.value -= 1
            }

            fun navigateToDashboard() {
                val route = Screen.Dashboard.route
                onNavigateToDashboardScreen(route)
            }
            when (screenNumber.value) {
                0 -> OnboardingContentOne { increasePageNumber() }
                1 -> OnboardingContentTwo({ increasePageNumber() }, { decreasePageNumber() })
                2 -> OnboardingContentThree({ navigateToDashboard() }, { decreasePageNumber() }, name)
            }
        }
    }
}

@Composable
fun OnboardingContentOne(increasePageCount: () -> Unit) {
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

                Spacer(modifier = Modifier.height(50.dp))
                Image(
                    painter = painterResource(R.drawable.wallet),
                    contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .width(100.dp)
                )
                Text("Track Expenses", style = MaterialTheme.typography.h4, color = Color.White)
                Text(
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    text = "Lorem Ipsum is simply dummy text of " +
                            "the printing and typesetting industry. Lorem Ipsum has been the " +
                            "industry's standard dummy text ever since the 1500s, when an unknown " +
                            "printer took a galley of type and scrambled it to make a type specimen" +
                            " book. It has survived not only five centuries, but also the leap into " +
                            "electronic typesetting, remaining essentially unchanged. It was popularised" +
                            "containing Lorem",
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Clip
                )
                Spacer(modifier = Modifier.height(50.dp))
            }

        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = increasePageCount) {
            Text(text = "Let's Begin", style = MaterialTheme.typography.h6)
        }
    }
}

@Composable
fun OnboardingContentTwo(increasePageCount: () -> Unit, decreasePageCount: () -> Unit) {
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

                Spacer(modifier = Modifier.height(50.dp))
                Image(
                    painter = painterResource(R.drawable.money_bag),
                    contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .width(100.dp)
                )
                Text("Economise", style = MaterialTheme.typography.h4, color = Color.White)
                Text(
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    text = "Lorem Ipsum is simply dummy text of " +
                            "the printing and typesetting industry. Lorem Ipsum has been the " +
                            "industry's standard dummy text ever since the 1500s, when an unknown " +
                            "printer took a galley of type and scrambled it to make a type specimen" +
                            " book. It has survived not only five centuries, but also the leap into " +
                            "electronic typesetting, remaining essentially unchanged. It was popularised" +
                            "containing Lorem",
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Clip
                )
                Spacer(modifier = Modifier.height(50.dp))
            }

        }
        Spacer(modifier = Modifier.height(50.dp))

        Row() {
            Button(onClick = decreasePageCount) {
                Text(text = "Back", style = MaterialTheme.typography.h6)
            }
            Spacer(modifier = Modifier.padding(60.dp))
            Button(onClick = increasePageCount) {
                Text(text = "Next", style = MaterialTheme.typography.h6)
            }
        }

    }
}

@Composable
fun OnboardingContentThree(
    increasePageCount: () -> Unit,
    decreasePageCount: () -> Unit,
    name: MutableState<String>
) {
//    var name = remember { mutableStateOf("") }

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

                Spacer(modifier = Modifier.height(50.dp))
                Image(
                    painter = painterResource(R.drawable.money),
                    contentDescription = null,
                    Modifier
                        .height(100.dp)
                        .width(100.dp)
                )
                Text("Enter Full Name", style = MaterialTheme.typography.h4, color = Color.White)
                OutlinedTextField(
                    value = name.value,
                    onValueChange = { name.value = it },
                    textStyle = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp,
                    ),
                    label = { Text("Full Name") },
                    maxLines = 1,
                )
                Spacer(modifier = Modifier.height(50.dp))
            }

        }
        Spacer(modifier = Modifier.height(50.dp))

        Row() {
            Button(onClick = decreasePageCount) {
                Text(text = "Back", style = MaterialTheme.typography.h6)
            }
            Spacer(modifier = Modifier.padding(60.dp))
            Button(onClick = increasePageCount) {
                Text(text = "Next", style = MaterialTheme.typography.h6)
            }
        }

    }
}