package net.maiatoday.sketch

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.dp
import net.maiatoday.components.drawModifier
import net.maiatoday.ui.Bluebell
import net.maiatoday.ui.Minty
import net.maiatoday.ui.Persimmon
import net.maiatoday.ui.Sky

//region Gradient Brush
val brush = Brush.verticalGradient(listOf(Persimmon, Sky))
val brush1 = Brush.horizontalGradient(listOf(Color.Red, Color.Magenta, Color.White, Color.Red))
val brush2 = Brush.radialGradient(listOf(Color.Red, Color.Magenta, Color.White, Color.LightGray))
val brush3 = Brush.radialGradient(listOf(Minty, Sky, Bluebell))

@Composable
@Preview
fun BrushSwatch() {
    Canvas(modifier = drawModifier) {
        drawRect(
            brush = brush,
            style = Fill,
        )
    }
}
//endregion

//region Gradient brush with stops
@Preview
@Composable
fun BoxBrushSwatch() {
    val colorStops = arrayOf(
        0.0f to Color.Red,
        0.8f to Color.White,
        1f to Color.Magenta
    )
    Box(
        modifier = Modifier
            .requiredSize(200.dp)
            .background(Brush.horizontalGradient(colorStops = colorStops))
    )
}
//endregion

//region Messy brushes - don't look
@Composable
@Preview
fun ColorSwatch() {
    Canvas(modifier = drawModifier) {
        val swatchSize = 250.dp.toPx()
        drawRect(
            color = Color.Magenta,
            style = Fill,
            topLeft = Offset(center.x - swatchSize/2, center.y - swatchSize/2),
            size = Size(swatchSize,swatchSize)
        )
    }
}

//val pinkToWhite = listOf(
//    Color(255, 105, 180),
//    Color(255, 255, 255),
//)

//val rgbRainbow = listOf(
//    Color.Red,
//    Color.Yellow,
//    Color.Green,
//    Color.Cyan,
//    Color.Blue,
//    Color.Magenta
//)
//endregion


