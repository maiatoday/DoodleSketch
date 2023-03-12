package net.maiatoday.components

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke

data class Settings(
    val orbitRadius: Double = 300.0,
)

@Composable
fun SettingsPanel(drawModifier:Modifier) {
    Canvas(modifier = drawModifier) {
        drawCircle(
            color = Color.Magenta,
            center = center,
            radius = 100f,
            style = Stroke(width = 10f),
        )
    }
}

@Preview
@Composable
fun SettingsPanelPreview() {
    val drawModifier = Modifier
        .fillMaxSize()
        .clipToBounds()
    SettingsPanel(drawModifier)
}