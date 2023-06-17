package com.hamdan.rockpaperscissors.view.widgets

import androidx.annotation.StringRes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.hamdan.rockpaperscissors.SINGLE_LINE_TEXT

@Composable
fun TitleText(
    modifier: Modifier = Modifier,
    @StringRes textId: Int,
    textColor: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        modifier = modifier,
        text = stringResource(id = textId),
        style = MaterialTheme.typography.displayLarge,
        color = textColor,
        overflow = TextOverflow.Ellipsis,
        maxLines = SINGLE_LINE_TEXT,
    )
}

@Composable
fun SubtitleText(
    modifier: Modifier = Modifier,
    @StringRes textId: Int,
    textColor: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        modifier = modifier,
        text = stringResource(id = textId),
        style = MaterialTheme.typography.bodyLarge,
        color = textColor,
        overflow = TextOverflow.Ellipsis,
        maxLines = SINGLE_LINE_TEXT,
    )
}

@Composable
fun CardText(
    modifier: Modifier = Modifier,
    @StringRes textId: Int,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
) {
    Text(
        modifier = modifier,
        text = stringResource(id = textId),
        style = MaterialTheme.typography.bodyMedium,
        color = textColor,
        overflow = TextOverflow.Ellipsis,
        maxLines = SINGLE_LINE_TEXT,
    )
}
