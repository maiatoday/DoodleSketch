import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import net.maiatoday.components.Page
import net.maiatoday.sketch.*

fun main() = application {
    Window(
        title = "Doodle Sketch Blue Blocks",
        state = rememberWindowState(width = 550.dp, height = 550.dp),
        resizable = false,
        onCloseRequest = ::exitApplication
    ) {
        BlueBlocks()
    }
}
