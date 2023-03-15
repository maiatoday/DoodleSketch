package net.maiatoday.tools

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import net.maiatoday.ui.sketchColors
import kotlin.random.Random
fun randomThemeColor(): Color = sketchColors.random()


fun randomColor(): Color {
    val colorRange = 0..255
    val r = colorRange.random()
    val g = colorRange.random()
    val b = colorRange.random()
    return Color(r, g, b)
}

fun randomGrey(): Color {
    val colorRange = 0..255
    val c = colorRange.random()
    return Color(c, c, c)
}

const val DOT_COUNT = 200
fun randomOffset(size: Size) =
    Offset(
        x = Random.nextInt(0, size.width.toInt()).toFloat(),
        y = Random.nextInt(0, size.height.toInt()).toFloat()
    )
