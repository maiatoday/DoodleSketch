import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import net.maiatoday.sketch.*

fun main() = application {
    Window(
        title = "Doodle Sketch Blue Blocks",
        state = rememberWindowState(width = 990.dp, height = 990.dp),
        resizable = false,
        onCloseRequest = ::exitApplication
    ) {
        BlueBlocks()
    }
}
