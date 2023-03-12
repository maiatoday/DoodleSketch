package net.maiatoday.sketch

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color

@Composable
@Preview
fun Page(
    modifier: Modifier = Modifier.fillMaxSize(),
    color: Color = Color.White,
    content: @Composable BoxScope.() -> Unit
) {
    val drawModifier = modifier
        .background(color)
        .clipToBounds()
    Box(modifier = drawModifier) {
        content()
    }
}