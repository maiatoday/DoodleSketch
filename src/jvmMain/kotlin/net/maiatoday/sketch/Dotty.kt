package net.maiatoday.sketch

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import kotlin.random.Random

@Composable
@Preview
fun MagentaCircle() {
    val drawModifier = Modifier
        .fillMaxSize()
        .clipToBounds()
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
    val drawModifier = Modifier
        .fillMaxSize()
        .clipToBounds()
    Canvas(modifier = drawModifier) {
        drawOval(
            color = Color(255,105,180),
            topLeft = center,
            size = Size(100f,50f),
            style = Fill,
        )
    }
}

@Composable
@Preview
fun LimeOval() {
    val drawModifier = Modifier
        .fillMaxSize()
        .clipToBounds()
    Canvas(modifier = drawModifier) {
        drawOval(
            color = Color(0,255,0),
            topLeft = center,
            size = Size(50f,150f),
            style = Fill,
        )
    }
}

@Composable
@Preview
fun LotsOfDoughnuts() {
    val drawModifier = Modifier
        .fillMaxSize()
        .clipToBounds()
    Canvas(modifier = drawModifier) {
        for (dot in dots) {
            drawCircle(
                color = randomColor(),
                center = dot,
                radius = Random.nextInt(10,50).toFloat(),
                style = Stroke(width = 10f),
            )
        }
    }
}

@Composable
@Preview
fun LotsOfDots() {
    val drawModifier = Modifier
        .fillMaxSize()
        .clipToBounds()
    Canvas(modifier = drawModifier) {
        for (dot in dots) {
            drawCircle(
                color = randomColor(),
                center = dot,
                radius = Random.nextInt(10,50).toFloat(),
                style = Fill,
            )
        }
    }
}