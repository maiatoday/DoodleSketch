package net.maiatoday.sketch

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill

@Composable
@Preview
fun OneLine() {
    val drawModifier = Modifier
        .fillMaxSize()
        .clipToBounds()
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

data class StartEnd(val start:Offset, val end:Offset)
const val LINE_COUNT = 100
const val PAGE_SIZE = 1000

val lines:List<StartEnd> = buildList {
   repeat(LINE_COUNT) {
       add(StartEnd(randomOffset(0,PAGE_SIZE), randomOffset(0,PAGE_SIZE)))
   }
}

@Composable
@Preview
fun LotsOfLines() {
    val drawModifier = Modifier
        .fillMaxSize()
        .clipToBounds()
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
    val drawModifier = Modifier
        .fillMaxSize()
        .clipToBounds()
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