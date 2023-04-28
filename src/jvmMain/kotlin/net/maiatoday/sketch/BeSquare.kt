package net.maiatoday.sketch

import androidx.compose.animation.core.*
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import net.maiatoday.components.drawModifier
import net.maiatoday.components.roundedSwatch
import net.maiatoday.components.swatch
import net.maiatoday.tools.randomRotations
import net.maiatoday.ui.*

//region Blue Square
@Composable
@Preview
fun BlueSquare() {
    val squareSize = 150f
    Canvas(modifier = drawModifier.padding(8.dp)) {
        drawRect(
            color = Bluebell,
            style = Stroke(width = 20f),
            size = Size(squareSize, squareSize)
        )
    }
}
//endregion

//region Filled Blue Square
@Composable
@Preview
fun FilledBlueSquare() {
    val squareSize = 150f
    Canvas(modifier = drawModifier.padding(8.dp)) {
        drawRect(
            color = Sky,
            style = Fill,
           // topLeft = Offset(50f,50f),
            size = Size(squareSize, squareSize)
        )
    }
}
//endregion

//region Center Blue Square
@Composable
@Preview
fun CenterBlueSquare() {
    val squareSize = 300f
    val sd = 100.dp

    Canvas(modifier = drawModifier) {
        drawRect(
            color = Turquoise,
            style = Fill,
            size = Size(squareSize, squareSize),
            topLeft = Offset(center.x - squareSize / 2, center.y - squareSize / 2)
        )
        drawCircle(
            color = Persimmon,
            radius = 5f,
            center = center
        )
    }
}
//endregion

//region Rounded Grey Square
@Composable
@Preview
fun RoundedGreySquare() {
    val squareSize = 150f
    Canvas(modifier = drawModifier.padding(8.dp)) {
        drawRoundRect(
            color = Charcoal,
            style = Fill,
            size = Size(squareSize, squareSize),
            topLeft = Offset(size.width - squareSize, size.height - squareSize),
            cornerRadius = CornerRadius(10f, 10f)
        )
    }
}
//endregion

//region Blue experiments - don't look
const val blockSplitCount = 9
const val blockMax = blockSplitCount * blockSplitCount
const val midBlock = blockMax / 2
val rotations = randomRotations(blockMax)

@Composable
fun DoodlingBlueBlocks() {
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
    BlueBlocks(blockCount, paddingVal, squareSize)
}

@Composable
fun BlueBlocks(blockCount: Float, paddingVal: Int = 10, squareSize: Float = 100f) {
    Canvas(modifier = drawModifier) {
        var offset = Offset.Zero
        repeat(blockCount.toInt()) { count ->
//            rotate(degrees = rotations[count], pivot = offset) {
                when {
                    count == midBlock -> roundedSwatch(offset = offset, color = Minty)
                    count % 2 == 0 -> swatch(fill = true, offset = offset, color = Bluebell)
                    else -> swatch(offset = offset, color = Sky)
                }
                val (x, y) = if (count % blockSplitCount == blockSplitCount - 1) {
                    (0f to offset.y + paddingVal + squareSize)
                } else {
                    (offset.x + paddingVal + squareSize to offset.y)
                }
                offset = Offset(x, y)
//            } // end rotate
        }
    }
}

@Composable
@Preview
fun BlueBlocksPreview() {
    BlueBlocks(blockMax.toFloat())
}
//endregion