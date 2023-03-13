package net.maiatoday.sketch

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import net.maiatoday.components.Choices
import net.maiatoday.components.drawModifier
import net.maiatoday.tools.randomColor
import net.maiatoday.tools.randomGrey
import net.maiatoday.tools.randomOffset

//region One Line and coordinate system
@Composable
@Preview
fun OneLine() {
    Canvas(modifier = drawModifier) {
        drawCircle(
            color = Color.Magenta,
            center = center,
            radius = 5f,
            style = Fill
        )
        drawLine(
            color = Color.Black,
            strokeWidth = 2f,
            start = center,
            end = Offset(center.x+100, center.y+100)
        )

    }
}
//endregion

//region Lots of Lines with rainbows
data class StartEnd(val start:Offset, val end:Offset)
const val LINE_COUNT = 100
const val PAGE_SIZE = 1000

val lines:List<StartEnd> = buildList {
   repeat(LINE_COUNT) {
       add(StartEnd(randomOffset(Size(PAGE_SIZE.toFloat(), PAGE_SIZE.toFloat())), randomOffset(Size(PAGE_SIZE.toFloat(), PAGE_SIZE.toFloat()))))
   }
}

@Composable
@Preview
fun LotsOfLines() {
    Canvas(modifier = drawModifier) {
        for (line in lines) {
            drawLine(
                color = Color.Black,
                strokeWidth = 2f,
                start = line.start,
                end = line.end
            )
        }
    }
}

@Composable
@Preview
fun LotsOfRainbowLines() {
    Canvas(modifier = drawModifier) {
        for (line in lines) {
            drawLine(
                color = randomColor(),
                strokeWidth = 2f,
                start = line.start,
                end = line.end
            )
        }
    }
}
//endregion

//region Lines with choices - For later don't look
@Composable
fun AllTheLines(choices: Choices = Choices()) {
    Canvas(modifier = drawModifier) {
        repeat(choices.dotCount) {
            drawLine(
                color = if (choices.rainbowLines) randomColor() else randomGrey(),
                strokeWidth = 4f,
                start = randomOffset(size),
                end = randomOffset(size)
            )
        }
    }
}
//endregion