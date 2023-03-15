import androidx.compose.foundation.layout.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import net.maiatoday.components.Choices
import net.maiatoday.components.ChoicesPanel
import net.maiatoday.components.MAX_DOT_COUNT
import net.maiatoday.components.Page
import net.maiatoday.sketch.*
import net.maiatoday.tools.randomOffset
import net.maiatoday.ui.DoodleSketchTheme

fun main() = application {
    DoodleSketchTheme {
        Window(
            title = "Doodle Sketch",
            state = rememberWindowState(width = 1200.dp, height = 800.dp),
            resizable = false,
            onCloseRequest = ::exitApplication
        ) {
            var choices by remember { mutableStateOf(Choices()) }
            var points by remember { mutableStateOf(buildPoints(choices.size, MAX_DOT_COUNT)) }

            val settingsModifier = Modifier
                .requiredWidth(200.dp)
                .fillMaxHeight()
                .clipToBounds()

            val pageModifier = Modifier
                .requiredWidth(1000.dp)
                .fillMaxHeight()
                .clipToBounds()
            Row(modifier = Modifier.wrapContentSize()) {
                Page(modifier = pageModifier.onSizeChanged {
                    points = buildPoints(it, MAX_DOT_COUNT)
                    choices = choices.copy(size = it)
                }) {
                    if (choices.showLines) AllTheLines(choices, points)
                    if (choices.showDots) AllTheDots(choices, points)
                }
                ChoicesPanel(
                    modifier = settingsModifier,
                    choices = choices,
                    onNewPoints = { points = buildPoints(choices.size, MAX_DOT_COUNT) }) { choices = it }
            }
        }
    }
}

fun buildPoints(size: IntSize, count: Int): List<Offset> = buildList {
    repeat(count + 1) {
        add(randomOffset(size.toSize()))
    }
}
