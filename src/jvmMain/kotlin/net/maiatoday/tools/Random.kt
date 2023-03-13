package net.maiatoday.tools

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import net.maiatoday.sketch.PAGE_SIZE
import kotlin.random.Random

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

fun randomOffset(x: Int, y: Int): Offset =
    Offset(Random.nextInt(0, x).toFloat(), Random.nextInt(0, y).toFloat())
