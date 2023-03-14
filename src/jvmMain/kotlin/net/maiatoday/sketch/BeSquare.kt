package net.maiatoday.sketch

import androidx.compose.animation.core.*
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import net.maiatoday.components.drawModifier

//region Blue Square
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
//endregion

//region Filled Blue Square
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
//endregion

//region Center Blue Square
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
//endregion

//region Rounded Grey Square
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
//endregion

//region Blue experiments - don't look
val blue1 = Color(127, 144, 244)
val blue2 = Color(91, 193, 238)
val minty = Color(28, 233, 182)
const val blockSplitCount = 9
const val blockMax = blockSplitCount * blockSplitCount
const val midBlock = blockMax / 2

@Composable
@Preview
fun BlueBlocks() {
    val infiniteTransition = rememberInfiniteTransition()
    val blockCount: Float by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = blockMax.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(10000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val paddingVal = 10
    val squareSize = 100f
    Canvas(modifier = drawModifier) {
        var offset = Offset.Zero
        repeat(blockCount.toInt()) { count ->
            when {
                count == midBlock -> roundedSwatch(offset = offset, color = minty)
                count % 2 == 0 -> swatch(fill = true, offset = offset, color = blue1)
                else -> swatch(offset = offset, color = blue2)
            }
            val (x, y) = if (count % blockSplitCount == blockSplitCount - 1) {
                (0f to offset.y + paddingVal + squareSize)
            } else {
                (offset.x + paddingVal + squareSize to offset.y)
            }
            offset = Offset(x, y)
        }
    }

}

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
//endregion