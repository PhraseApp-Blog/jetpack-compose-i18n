
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
import com.elixer.wallet.presentation.ui.onboarding.UpdateName
import com.elixer.wallet.presentation.ui.onboarding.termsAndConditions
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
                0 -> termsAndConditions { increasePageNumber() }
                1 -> UpdateName(
                    { saveAndNavigateToDashboard() },
                    { decreasePageNumber() },
                    name
                )
            }
        }
    }
}