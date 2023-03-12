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

fun randomGrey(): Color {
    val colorRange = 0..255
    val c = colorRange.random()
    return Color(c, c, c)
}

fun randomOffset(x: Int, y: Int): Offset =
    Offset(Random.nextInt(0, x).toFloat(), Random.nextInt(0, y).toFloat())

const val DOT_COUNT = 200
val dots: List<Offset> = buildList {
    repeat(DOT_COUNT) {
        add(randomOffset(PAGE_SIZE, PAGE_SIZE))
    }
}