import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import net.maiatoday.sketch.BlueSquare
import net.maiatoday.sketch.MagentaCircle
import net.maiatoday.sketch.Page

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        Page {
            MagentaCircle()
            BlueSquare()
        }
    }
}
