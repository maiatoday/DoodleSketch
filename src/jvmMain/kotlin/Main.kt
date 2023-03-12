import androidx.compose.foundation.layout.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import net.maiatoday.components.Choices
import net.maiatoday.components.DoodleChoicesPanel
import net.maiatoday.sketch.*

fun main() = application {
    Window(
        title = "Doodle Sketch",
        state = rememberWindowState(width = 1200.dp, height = 800.dp),
        resizable = false,
        onCloseRequest = ::exitApplication
    ) {
        var choices by remember { mutableStateOf(Choices()) }

        val settingsModifier = Modifier
            .requiredWidth(600.dp)
            .fillMaxHeight()
            .clipToBounds()

        val pageModifier = Modifier
            .requiredWidth(600.dp)
            .fillMaxHeight()
            .clipToBounds()
        Row(modifier = Modifier.wrapContentSize()) {
            Page(modifier = pageModifier) {
                if (choices.showDots) AllTheDoughnuts(choices)
                if (choices.showLines) AllTheLines(choices)
            }
            DoodleChoicesPanel(settingsModifier, choices) { choices = it }
        }
    }
}
