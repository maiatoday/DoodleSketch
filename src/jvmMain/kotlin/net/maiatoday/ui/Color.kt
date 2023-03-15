package net.maiatoday.ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import net.maiatoday.components.Swatch

val Sky = Color(66, 133, 244)
val Spearmint = Color(100, 195, 166)
val Minty = Color(28, 233, 182)
val Turquoise = Color(91, 193, 238)
val Charcoal = Color(65, 64, 66)
val Dove = Color(197, 197, 197)
val Persimmon = Color(255, 115, 112)
val Peach = Color(255, 208, 174)
val Bluebell = Color(127, 144, 244)

val sketchColors = listOf(
    Sky,
    Spearmint,
    Minty,
    Turquoise,
    Charcoal,
    Dove,
    Persimmon,
    Peach,
    Bluebell,
)

@Preview
@Composable
fun previewColours() {
    Column {
        for (c in sketchColors) {
            Swatch(color = c)
        }
    }
}