import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.aay.common.App
import ui.Desktop

fun main() = application {
    val windowState = rememberWindowState(placement = WindowPlacement.Maximized)

    Window(
        title = "张老师666",
        onCloseRequest = ::exitApplication,
        state = windowState
    ) {
        Desktop()
    }

}
