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
import net.maiatoday.components.Settings
import net.maiatoday.components.SettingsPanel
import net.maiatoday.sketch.*

fun main() = application {
    Window(
        title = "Doodle Sketch",
        onCloseRequest = ::exitApplication
    ) {
        var settings by remember { mutableStateOf(Settings()) }

        val settingsModifier = Modifier
            .requiredWidth(300.dp)
            .fillMaxHeight()
            .clipToBounds()

        val pageModifier = Modifier
            .requiredWidth(600.dp)
            .fillMaxHeight()
            .clipToBounds()
        Row {
            Page(modifier = pageModifier) {
                LotsOfDoughnuts()
                LotsOfRainbowLines()
            }
            SettingsPanel(settingsModifier)
        }
    }
}
