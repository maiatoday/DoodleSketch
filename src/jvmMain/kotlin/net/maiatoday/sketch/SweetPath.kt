package net.maiatoday.sketch

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.*
import net.maiatoday.components.drawModifier
import net.maiatoday.tools.DOT_COUNT
import net.maiatoday.tools.randomColor
import net.maiatoday.tools.randomGrey
import net.maiatoday.tools.randomOffset
import net.maiatoday.ui.Persimmon
import net.maiatoday.ui.Sky

//region Triangle walk
@Composable
@Preview
fun TriangleWalk() {
    Canvas(modifier = drawModifier) {
        val path = Path()
        path.moveTo(0f, 0f)
        path.lineTo(0f, center.y)
        path.lineTo(size.width, 0f)
        path.close()
        drawPath(path, Color.Magenta, style = Stroke(width = 10f))
    }
}
//endregion

//region Heart path
//// Thank You https://mahendranv.github.io/posts/compose-shapes-gists/
val heartSize = Size(150f, 150f)
val heartPath = Path().apply {
    val w = heartSize.width
    val h = heartSize.height
    moveTo(0.5f * w, 0.25f * h)
    cubicTo(
        0.5f * w, 0.225f * h,
        0.45833f * w, 0.125f * h,
        0.291667f * w, 0.125f * h
    )
    cubicTo(0.041667f * w, 0.125f * h, 0.041667f * w, 0.4f * h, 0.041667f * w, 0.4f * h)
    cubicTo(0.041667f * w, 0.58333f * h, 0.20833f * w, 0.76667f * h, 0.5f * w, 0.91667f * h)
    cubicTo(0.791667f * w, 0.76667f * h, 0.95833f * w, 0.58333f * h, 0.95833f * w, 0.4f * h)
    cubicTo(0.9533f * w, 0.4f * h, 0.95833f * w, 0.125f * h, 0.70833f * w, 0.125f * h)
    cubicTo(0.5833f * w, 0.125f * h, 0.5f * w, 0.225f * h, 0.5f * w, 0.25f * h)
    close()
}

@Composable
@Preview
fun HeartEdge() {
    Canvas(modifier = drawModifier) {
        drawPath(
            path = heartPath,
            color = Color.Magenta,
            style = Stroke(width = 10f)
        )
    }
}
//endregion

//region Candy Heart
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
    Canvas(modifier = drawModifier) {
        drawPath(
            path = heartPath,
            brush = customBrush,
            style = Fill
        )
    }
}
//endregion

//region Transforming hearts
@Composable
@Preview
fun HeartCenter() {
    Canvas(modifier = drawModifier) {
        translate(center.x, center.y) {
            drawPath(heartPath, Color.Red, style = Fill)
        }
    }
}

@Composable
@Preview
fun HeartSpin() {
    Canvas(modifier = drawModifier) {
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
                degrees = 100f,
                pivot = Offset.Zero
            )
        }) {
            drawRect(color = Color.LightGray, topLeft = Offset.Zero, size = heartSize, style = Stroke(width = 2f))
            drawPath(heartPath, Color.Cyan, style = Fill)
        }
    }
}
//endregion

//region Heart pulse
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
        initialValue = Sky,
        targetValue = Persimmon,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Canvas(modifier = drawModifier) {
        withTransform({
            scale(heartScale)
            translate(center.x - heartSize.width / 2, center.y - heartSize.height / 2)

        }) {
            drawPath(
                heartPath,
                color = heartColor,
                style = Fill
            )
        }
    }
}
//endregion

//region Messy - don't look
@Composable
@Preview
fun HappyHearts() {
    Canvas(modifier = drawModifier) {
        repeat(DOT_COUNT) {
            val d = randomOffset(size)
            translate(d.x, d.y) {
                drawPath(heartPath, randomColor(), style = Fill)
            }
        }
    }
}

@Composable
@Preview
fun SadHearts() {
    Canvas(modifier = drawModifier) {
        repeat(DOT_COUNT) {
            val d = randomOffset(size)
            translate(d.x, d.y) {
                drawPath(heartPath, randomGrey(), style = Fill)
            }
        }
    }
}
//endregion
