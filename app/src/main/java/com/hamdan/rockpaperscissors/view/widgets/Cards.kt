package com.hamdan.rockpaperscissors.view.widgets

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.hamdan.rockpaperscissors.R
import com.hamdan.rockpaperscissors.RPSOption
import com.hamdan.rockpaperscissors.view.theme.dimens

// Needs to be updated whenever a RPSOption is added
@Composable
fun RPSOptionCard(
    modifier: Modifier = Modifier,
    onSelect: () -> Unit,
    selected: Boolean = false,
    option: RPSOption?,
) {
    Card(
        modifier = modifier
            .padding(MaterialTheme.dimens.grid.x2)
            .clip(CardDefaults.shape)
            .clickable { onSelect() }
            .size(MaterialTheme.dimens.iconGrid.x4),
        border = if (selected) BorderStroke(
            MaterialTheme.dimens.borderGrid.x2,
            Color.Blue,
        ) else null
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            RPSOptionCardBody(option = option)
        }
    }
}

@Composable
fun RPSDisplayCard(
    modifier: Modifier = Modifier,
    option: RPSOption? = null,
    @StringRes text: Int? = null,
) {
    Card(
        modifier = modifier
            .padding(MaterialTheme.dimens.grid.x2)
            .size(MaterialTheme.dimens.iconGrid.x6),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            RPSOptionCardBody(option = option)
            text?.let {
                CardText(textId = it)
            }
        }
    }
}

@Composable
fun ColumnScope.RPSOptionCardBody(option: RPSOption?) {
    when (option) {
        RPSOption.ROCK -> {
            Icon(
                painter = painterResource(id = R.drawable.rps_rock),
                contentDescription = stringResource(id = R.string.rps_rock_description),
                Modifier.size(MaterialTheme.dimens.grid.x10)
            )
            CardText(textId = R.string.game_rock_text)
        }

        RPSOption.PAPER -> {
            Icon(
                painter = painterResource(id = R.drawable.rps_paper),
                contentDescription = stringResource(id = R.string.rps_paper_description),
                Modifier.size(MaterialTheme.dimens.grid.x10)
            )
            CardText(textId = R.string.game_paper_text)
        }

        RPSOption.SCISSOR -> {
            Icon(
                painter = painterResource(id = R.drawable.rps_scissor),
                contentDescription = stringResource(id = R.string.rps_scissor_description),
                Modifier.size(MaterialTheme.dimens.grid.x10)
            )
            CardText(textId = R.string.game_scissor_text)
        }

        else -> {
            Icon(
                painter = painterResource(id = R.drawable.rps_question_mark),
                contentDescription = stringResource(id = R.string.rps_question_mark_description),
                Modifier.size(MaterialTheme.dimens.grid.x10)
            )
        }
    }
}
