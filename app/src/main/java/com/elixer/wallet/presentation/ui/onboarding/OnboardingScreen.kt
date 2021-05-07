
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.elixer.wallet.presentation.navigation.Screen
import com.elixer.wallet.presentation.theme.WalletTheme
import com.elixer.wallet.presentation.ui.onboarding.OnboardingViewModel
import com.elixer.wallet.presentation.ui.onboarding.TermsAndConditions
import com.elixer.wallet.presentation.ui.onboarding.UpdateName
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun OnBoardingScreen(
    viewModel: OnboardingViewModel,
    onNavigateToDashboardScreen: (String) -> Unit,
    updateName: (String) -> Unit
) {

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

            fun saveAndNavigateToDashboard() {
                updateName(name.value)
                val route = Screen.Dashboard.route
                onNavigateToDashboardScreen(route)
            }
            when (screenNumber.value) {
                0 -> TermsAndConditions { increasePageNumber() }
                1 -> UpdateName(
                    { saveAndNavigateToDashboard() },
                    { decreasePageNumber() },
                    name
                )
            }
        }
    }
}

//Repurpose this later
//@Composable
//fun OnboardingContentOne(increasePageCount: () -> Unit) {
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//        Surface(
//            color = Color.DarkGray, modifier = Modifier
//                .height(600.dp)
//                .fillMaxWidth(),
//            shape = RoundedCornerShape(30.dp).copy(
//                topStart = ZeroCornerSize,
//                topEnd = ZeroCornerSize
//            )
//        ) {
//
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.padding(10.dp)
//            ) {
//
//                Spacer(modifier = Modifier.height(50.dp))
//                Image(
//                    painter = painterResource(R.drawable.wallet),
//                    contentDescription = null,
//                    Modifier
//                        .height(100.dp)
//                        .width(100.dp)
//                )
//                Html.kt(
//                    text = stringResource(R.string.header_name),
//                    style = MaterialTheme.typography.h4,
//                    color = Color.White
//                )
//                Html.kt(
//                    textAlign = TextAlign.Center,
//                    color = Color.White,
//                    text = "Lorem Ipsum is simply dummy text of " +
//                            "the printing and typesetting industry. Lorem Ipsum has been the " +
//                            "industry's standard dummy text ever since the 1500s, when an unknown " +
//                            "printer took a galley of type and scrambled it to make a type specimen" +
//                            " book. It has survived not only five centuries, but also the leap into " +
//                            "electronic typesetting, remaining essentially unchanged. It was popularised" +
//                            "containing Lorem",
//                    style = MaterialTheme.typography.body1,
//                    overflow = TextOverflow.Clip
//                )
//                Spacer(modifier = Modifier.height(50.dp))
//            }
//
//        }
//        Spacer(modifier = Modifier.height(30.dp))
//        Button(onClick = increasePageCount, modifier = Modifier.width(50.dp)) {
//            Html.kt(text = stringResource(R.string.button_begin), style = MaterialTheme.typography.h6)
//        }
//    }
//}
//
//@Composable
//fun OnboardingContentTwo(increasePageCount: () -> Unit, decreasePageCount: () -> Unit) {
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//        Surface(
//            color = Color.DarkGray, modifier = Modifier
//                .weight(7f)
//                .fillMaxWidth(),
//            shape = RoundedCornerShape(30.dp).copy(
//                topStart = ZeroCornerSize,
//                topEnd = ZeroCornerSize
//            )
//        ) {
//
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.padding(10.dp)
//            ) {
//
//                Spacer(modifier = Modifier.height(50.dp))
//                Image(
//                    painter = painterResource(R.drawable.money_bag),
//                    contentDescription = null,
//                    Modifier
//                        .height(100.dp)
//                        .width(100.dp)
//                )
//                Html.kt("Economise", style = MaterialTheme.typography.h4, color = Color.White)
//                Html.kt(
//                    textAlign = TextAlign.Center,
//                    color = Color.White,
//                    text = "Lorem Ipsum is simply dummy text of " +
//                            "the printing and typesetting industry. Lorem Ipsum has been the " +
//                            "industry's standard dummy text ever since the 1500s, when an unknown " +
//                            "printer took a galley of type and scrambled it to make a type specimen" +
//                            " book. It has survived not only five centuries, but also the leap into " +
//                            "electronic typesetting, remaining essentially unchanged. It was popularised" +
//                            "containing Lorem",
//                    style = MaterialTheme.typography.body1,
//                    overflow = TextOverflow.Clip
//                )
//                Spacer(modifier = Modifier.height(50.dp))
//            }
//
//        }
//        Spacer(modifier = Modifier.height(50.dp))
//
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier
//                .weight(3f)
//        ) {
//            Button(onClick = decreasePageCount) {
//                Html.kt(
//                    text = stringResource(R.string.button_back),
//                    style = MaterialTheme.typography.h6
//                )
//            }
//            Spacer(modifier = Modifier.padding(60.dp))
//            Button(onClick = increasePageCount) {
//                Html.kt(
//                    text = stringResource(R.string.button_next),
//                    style = MaterialTheme.typography.h6
//                )
//            }
//        }
//
//    }
//}
//
