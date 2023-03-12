package net.maiatoday.sketch

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

fun randomColor(): Color {
    val colorRange = 0..255
    val r = colorRange.random()
    val g = colorRange.random()
    val b = colorRange.random()
    return Color(r, g, b)
}

fun randomOffset(low:Int, high:Int): Offset =
    Offset(Random.nextInt(low, high).toFloat(), Random.nextInt(low, high).toFloat())

