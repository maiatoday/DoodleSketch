package net.maiatoday.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun DrawScope.swatch(color: Color = Color.Blue, fill: Boolean = false, size: Float = 100f, offset: Offset) {
    drawRect(
        color = color,
        style = if (fill) Fill else Stroke(width = 10f),
        size = Size(size, size),
        topLeft = offset
    )
}

fun DrawScope.roundedSwatch(color: Color = Color.LightGray, fill: Boolean = true, size: Float = 100f, offset: Offset) {
    drawRoundRect(
        color = color,
        style = if (fill) Fill else Stroke(width = 10f),
        size = Size(size, size),
        topLeft = offset,
        cornerRadius = CornerRadius(10f, 10f)
    )
}

@Composable
fun Swatch(color: Color = Color.LightGray, name:String, size: Dp = 48.dp) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier =
            Modifier.padding(8.dp)
                .background(color)
                .size(size)
        )
        Text(name, color = color)
    }
}

