import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import net.maiatoday.sketch.*

fun main() = application {
    Window(
        title = "Doodle Sketch Samples",
        onCloseRequest = ::exitApplication
    ) {
        Page {
//            MagentaCircle()
//            FilledBlueSquare()
//            LotsOfRainbowLines()
//            LotsOfDoughnuts()
            HappyHearts()
            HeartPulse()
        }
    }
}