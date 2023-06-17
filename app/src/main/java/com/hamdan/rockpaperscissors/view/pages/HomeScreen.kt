package com.hamdan.rockpaperscissors.view.pages

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.hamdan.rockpaperscissors.R
import com.hamdan.rockpaperscissors.view.widgets.RPSColumn
import com.hamdan.rockpaperscissors.view.widgets.SubtitleText
import com.hamdan.rockpaperscissors.view.widgets.TitleText

@Composable
fun HomeScreen(
    onScreenPress: () -> Unit,
) {
    RPSColumn(modifier = Modifier.clickable { onScreenPress() }) {
        TitleText(textId = R.string.home_screen_title)
        val infiniteTransition = rememberInfiniteTransition()
        val animatedColor by infiniteTransition.animateColor(
            initialValue = MaterialTheme.colorScheme.onBackground,
            targetValue = MaterialTheme.colorScheme.onBackground.copy(alpha = .5f),
            animationSpec = infiniteRepeatable(
                animation = tween(1000, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            )
        )
        SubtitleText(textColor = animatedColor, textId = R.string.home_screen_subtitle)
    }
}
