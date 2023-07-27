package net.maiatoday.sketch

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import net.maiatoday.components.Choices
import net.maiatoday.components.drawModifier
import net.maiatoday.tools.*
import net.maiatoday.ui.Persimmon
import kotlin.random.Random

//region Magenta Circle
@Composable
@Preview
fun MagentaCircle() {
    Canvas(modifier = drawModifier) {
        drawCircle(
            color = Persimmon,
            center = center,
            radius = 100f,
            style = Stroke(width = 20f),
        )
    }
}
//endregion

//region Hot Pink and Lime oval
@Composable
@Preview
fun HotPinkOval() {
    Canvas(modifier = drawModifier) {
        drawOval(
            color = Color(255, 105, 180),
            topLeft = center,
            size = Size(50f, 150f),
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
            size = Size(150f, 250f),
            style = Fill,
        )
    }
}
//endregion

//region Lots of Doughnuts or Dots
@Composable
@Preview
fun LotsOfDoughnuts() {
    Canvas(modifier = drawModifier) {
        repeat(DOT_COUNT) {
            drawCircle(
                color = randomColor(),
                center = randomOffset(size),
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
        repeat(DOT_COUNT) {
            drawCircle(
                color = randomColor(),
                center = randomOffset(size),
                radius = Random.nextInt(10, 50).toFloat(),
                style = Fill,
            )
        }
    }
}
//endregion

//region Dots with choices - for later don't look
@Composable
fun AllTheDots(choices: Choices = Choices(), points:List<Offset>) {
    Canvas(modifier = drawModifier) {
        repeat(choices.dotCount) {
            drawCircle(
                color = if (choices.rainbowDots) randomThemeColor()  else randomGrey(),
                center = points[it],
                radius = Random.nextInt(10, 50).toFloat(),
                style = Fill,
            )
        }
    }
}

//endregion
