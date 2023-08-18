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

data class SwatchInfo(val color:Color, val name:String)
val sketchColors = listOf(
    SwatchInfo(Sky,"Sky"),
    SwatchInfo(Spearmint,"Spearmint"),
    SwatchInfo(Minty,"Minty"),
    SwatchInfo(Turquoise,"Turquoise"),
    SwatchInfo(Charcoal,"Charcoal"),
    SwatchInfo(Dove,"Dove"),
    SwatchInfo(Persimmon,"Persimmon"),
    SwatchInfo(Peach,"Peach"),
    SwatchInfo(Bluebell,"Bluebell"),
)

@Preview
@Composable
fun PreviewColours() {
    Column {
        for (swatch in sketchColors) {
            Swatch(color = swatch.color, swatch.name)
        }
    }
}