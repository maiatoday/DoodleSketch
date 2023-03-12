package net.maiatoday.sketch

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke

@Composable
@Preview
fun BlueSquare() {
    val drawModifier = Modifier
        .fillMaxSize()
        .clipToBounds()
    val size = 100f
    Canvas(modifier = drawModifier) {
        drawRect(
            color = Color.Blue,
            style = Stroke(width = 10f),
            size = Size(size, size)
        )
    }
}