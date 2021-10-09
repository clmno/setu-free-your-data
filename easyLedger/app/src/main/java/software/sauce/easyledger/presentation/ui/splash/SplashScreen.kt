package software.sauce.easyledger.presentation.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import software.sauce.easyledger.R
import software.sauce.easyledger.presentation.theme.EasyLedgerTheme

@Composable
fun SplashScreen(
    onNavigation: (String) -> Unit,
    viewModel: GlobalViewModel
) {

    val nextScreen = viewModel.nextScreen.value

    val onLoad = viewModel.onLoad.value

    EasyLedgerTheme {
        Scaffold(backgroundColor = MaterialTheme.colors.primary) {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                if (nextScreen == null) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_cashbook),
                        contentDescription = "App Logo",
                        modifier = Modifier
                            .weight(1f)
                            .size(200.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.app_name),
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp
                    )
                } else {
                    if (!onLoad) {
                        viewModel.onLoad.value = true
                        onNavigation(nextScreen.route)
                    }
                }
            }
        }
    }
}