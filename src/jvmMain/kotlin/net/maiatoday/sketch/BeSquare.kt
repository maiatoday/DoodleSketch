package net.maiatoday.sketch

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import net.maiatoday.components.drawModifier

@Composable
@Preview
fun BlueSquare() {
    val squareSize = 100f
    Canvas(modifier = drawModifier) {
        drawRect(
            color = Color.Blue,
            style = Stroke(width = 10f),
            size = Size(squareSize, squareSize)
        )
    }
}

@Composable
@Preview
fun FilledBlueSquare() {
    val squareSize = 100f
    Canvas(modifier = drawModifier) {
        drawRect(
            color = Color.Blue,
            style = Fill,
            size = Size(squareSize, squareSize)
        )
    }
}


@Composable
@Preview
fun CenterBlueSquare() {
    val squareSize = 100f
    Canvas(modifier = drawModifier) {
        drawRect(
            color = Color.Blue,
            style = Fill,
            size = Size(squareSize, squareSize),
            topLeft = Offset(center.x - squareSize / 2, center.y - squareSize / 2)
        )
    }
}


@Composable
@Preview
fun RoundedGreySquare() {
    val squareSize = 100f
    Canvas(modifier = drawModifier) {
        drawRoundRect(
            color = Color.DarkGray,
            style = Fill,
            size = Size(squareSize, squareSize),
            topLeft = Offset(size.width - squareSize - 10f, size.height - squareSize - 10f),
            cornerRadius = CornerRadius(10f, 10f)
        )
    }
}