package net.maiatoday.sketch

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.*
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.translate

@Composable
@Preview
fun TriangleWalk() {
    val drawModifier = Modifier
        .fillMaxSize()
        .clipToBounds()
    Canvas(modifier = drawModifier) {
        val path = Path()
        path.moveTo(0f, 0f)
        path.lineTo(center.x, center.y)
        path.lineTo(size.width, 0f)
        path.close()
        drawPath(path, Color.Magenta, style = Stroke(width = 10f))
    }
}

//// Thank You https://mahendranv.github.io/posts/compose-shapes-gists/
val heartSize = Size(150f, 150f)
val heartPath = Path().apply {
    val w = heartSize.width
    val h = heartSize.height
    moveTo(0.5f * w, 0.25f * h)
    cubicTo(0.5f * w, 0.225f * h, 0.458333333333333f * w, 0.125f * h, 0.291666666666667f * w, 0.125f * h)
    cubicTo(0.0416666666666667f * w, 0.125f * h, 0.0416666666666667f * w, 0.4f * h, 0.0416666666666667f * w, 0.4f * h)
    cubicTo(
        0.0416666666666667f * w,
        0.583333333333333f * h,
        0.208333333333333f * w,
        0.766666666666667f * h,
        0.5f * w,
        0.916666666666667f * h
    )
    cubicTo(
        0.791666666666667f * w,
        0.766666666666667f * h,
        0.958333333333333f * w,
        0.583333333333333f * h,
        0.958333333333333f * w,
        0.4f * h
    )
    cubicTo(0.958333333333333f * w, 0.4f * h, 0.958333333333333f * w, 0.125f * h, 0.708333333333333f * w, 0.125f * h)
    cubicTo(0.583333333333333f * w, 0.125f * h, 0.5f * w, 0.225f * h, 0.5f * w, 0.25f * h)
    close()
}

@Composable
@Preview
fun HeartEdge() {
    val drawModifier = Modifier
        .fillMaxSize()
        .clipToBounds()
    Canvas(modifier = drawModifier) {
        drawPath(heartPath, Color.Magenta, style = Stroke(width = 5f))
    }
}

@Composable
@Preview
fun HeartCenter() {
    val drawModifier = Modifier
        .fillMaxSize()
        .clipToBounds()
    Canvas(modifier = drawModifier) {
        translate(center.x, center.y) {
            drawPath(heartPath, Color.Red, style = Fill)
        }
    }
}

@Composable
@Preview
fun HeartSpin() {
    val drawModifier = Modifier
        .fillMaxSize()
        .clipToBounds()
    Canvas(modifier = drawModifier) {
        val pointBottomLeft = Offset(0f, size.height)
        val pointBottomRight = Offset(size.width, size.height)
        val pointTopLeft = Offset.Zero
        val pointTopRight = Offset(size.width, 0f)
        drawCircle(
            color = Color.Magenta,
            center = pointTopLeft,
            radius = 5f,
            style = Fill
        )
        drawCircle(
            color = Color.Magenta,
            center = center,
            radius = 5f,
            style = Fill
        )
        drawCircle(
            color = Color.Black,
            center = pointBottomLeft,
            radius = 5f,
            style = Fill
        )
        drawCircle(
            color = Color.Blue,
            center = pointTopRight,
            radius = 5f,
            style = Fill
        )
        rotate(
            degrees = 10F,
            pivot = Offset.Zero
        ) {
            drawPath(heartPath, Color.Green, style = Fill)
        }
    }
}

@Composable
@Preview
fun HeartCenterSpin() {
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
        withTransform({
            translate(center.x, center.y)
            rotate(
                degrees = 90f,
                pivot = Offset.Zero
            )
        }) {
            drawRect(color = Color.LightGray, topLeft = Offset.Zero, size = heartSize, style = Stroke(width = 2f))
            drawPath(heartPath, Color.Cyan, style = Fill)
        }
    }
}

@Composable
@Preview
fun HappyHearts() {
    val drawModifier = Modifier
        .fillMaxSize()
        .clipToBounds()
    Canvas(modifier = drawModifier) {
        repeat(DOT_COUNT) {
            val d = randomOffset(size.width.toInt(), size.height.toInt())
            translate(d.x, d.y) {
                drawPath(heartPath, randomColor(), style = Fill)
            }
        }
    }
}

@Composable
@Preview
fun SadHearts() {
    val drawModifier = Modifier
        .fillMaxSize()
        .clipToBounds()
    Canvas(modifier = drawModifier) {
        repeat(DOT_COUNT) {
            val d = randomOffset(size.width.toInt(), size.height.toInt())
            translate(d.x, d.y) {
                drawPath(heartPath, randomGrey(), style = Fill)
            }
        }
    }
}

@Composable
@Preview
fun HeartPulse() {
    val infiniteTransition = rememberInfiniteTransition()
    val heartScale by infiniteTransition.animateFloat(
        initialValue = 0.5f,
        targetValue = 1.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val heartColor by infiniteTransition.animateColor(
        initialValue = Color.Magenta,
        targetValue = Color.Red,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val drawModifier = Modifier
        .fillMaxSize()
        .clipToBounds()
    Canvas(modifier = drawModifier) {
        withTransform({
            scale(heartScale)
            translate(center.x - heartSize.width/2, center.y- heartSize.height/2)

        }) {
            drawPath(heartPath, color = heartColor, style = Fill)
        }
    }
}

val candyColours = listOf(Color.Red, Color.Magenta, Color(255, 105, 180))

@Composable
@Preview
fun CandyHeart() {
    val customBrush = remember {
        object : ShaderBrush() {
            override fun createShader(size: Size): Shader {
                return LinearGradientShader(
                    colors = candyColours,
                    from = Offset.Zero,
                    to = Offset(heartSize.width / 4f, 0f),
                    tileMode = TileMode.Mirror
                )
            }
        }
    }
    val drawModifier = Modifier
        .fillMaxSize()
        .clipToBounds()
    Canvas(modifier = drawModifier) {
        drawPath(heartPath, brush = customBrush, style = Fill)
    }
}
