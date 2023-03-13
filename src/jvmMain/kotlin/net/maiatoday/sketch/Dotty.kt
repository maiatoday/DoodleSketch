package net.maiatoday.sketch

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import net.maiatoday.components.Choices
import net.maiatoday.components.drawModifier
import net.maiatoday.tools.dots
import net.maiatoday.tools.randomColor
import net.maiatoday.tools.randomGrey
import net.maiatoday.tools.randomOffset
import kotlin.random.Random

@Composable
@Preview
fun MagentaCircle() {
    Canvas(modifier = drawModifier) {
        drawCircle(
            color = Color.Magenta,
            center = center,
            radius = 100f,
            style = Stroke(width = 10f),
        )
    }
}

@Composable
@Preview
fun HotPinkOval() {
    Canvas(modifier = drawModifier) {
        drawOval(
            color = Color(255, 105, 180),
            topLeft = center,
            size = Size(100f, 50f),
            style = Fill,
        )
    }
}

@Composable
@Preview
fun LimeOval() {
    Canvas(modifier = drawModifier) {
        drawOval(
            color = Color(0, 255, 0),
            topLeft = center,
            size = Size(50f, 150f),
            style = Fill,
        )
    }
}

@Composable
@Preview
fun LotsOfDoughnuts() {
    Canvas(modifier = drawModifier) {
        for (dot in dots) {
            drawCircle(
                color = randomColor(),
                center = dot,
                radius = Random.nextInt(10, 50).toFloat(),
                style = Stroke(width = 10f),
            )
        }
    }
}

@Composable
@Preview
fun LotsOfDots() {
    Canvas(modifier = drawModifier) {
        for (dot in dots) {
            drawCircle(
                color = randomColor(),
                center = dot,
                radius = Random.nextInt(10, 50).toFloat(),
                style = Fill,
            )
        }
    }
}

@Composable
fun AllTheDots(choices: Choices = Choices()) {
    Canvas(modifier = drawModifier) {
        repeat(choices.dotCount) {
            drawCircle(
                color = if (choices.rainbowDots) randomColor() else randomGrey(),
                center = randomOffset(size.width.toInt(), size.height.toInt()),
                radius = Random.nextInt(10, 50).toFloat(),
                style = Fill,
            )
        }
    }
}
