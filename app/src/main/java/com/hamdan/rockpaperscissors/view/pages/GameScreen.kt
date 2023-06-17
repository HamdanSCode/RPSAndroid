package com.hamdan.rockpaperscissors.view.pages

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.hamdan.rockpaperscissors.R
import com.hamdan.rockpaperscissors.RPSOption
import com.hamdan.rockpaperscissors.view.widgets.RPSColumn
import com.hamdan.rockpaperscissors.view.widgets.RPSDisplayCard
import com.hamdan.rockpaperscissors.view.widgets.RPSOptionCard
import com.hamdan.rockpaperscissors.view.widgets.RPSRow
import com.hamdan.rockpaperscissors.view.widgets.RPSScrollableColumn
import com.hamdan.rockpaperscissors.viewmodels.RPSViewModel

@Composable
fun GameScreen(
    orientation: Boolean = true, // default true for Landscape
    state: RPSViewModel.RPSState,
    onChoiceSelect: (RPSOption) -> Unit,
    onSubmit: () -> Unit,
) {
    if (orientation) {
        GameScreenLandscape(
            state,
            onChoiceSelect,
            onSubmit,
        )
    } else {
        GameScreenPortrait(
            state,
            onChoiceSelect,
            onSubmit,
        )
    }
}

@Composable
fun GameScreenPortrait(
    state: RPSViewModel.RPSState,
    onChoiceSelect: (RPSOption) -> Unit,
    onSubmit: () -> Unit,
) {
    RPSColumn() {
        Row(
            modifier = Modifier.weight(.25f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            // Selected Icon
            RPSDisplayCard(
                option = state.playerChoice,
                text = R.string.game_player_choice,
            )
        }
        Row(
            modifier = Modifier
                .weight(.25f)
                .horizontalScroll(rememberScrollState()),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            RPSOption.values().forEach {
                // Display a box with Icon and border for each
                RPSOptionCard(
                    onSelect = { onChoiceSelect(it) },
                    option = it,
                    selected = state.playerChoice == it,
                )
            }
        }
        Row(
            modifier = Modifier.weight(.25f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            // Button section
            Button(onClick = onSubmit) {
                Text(text = "Lock In")
            }
        }
        Row(
            modifier = Modifier.weight(.25f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            // Computer section
            RPSDisplayCard(
                text = R.string.game_computer_choice,
            )
        }
    }
}

@Composable
fun GameScreenLandscape(
    state: RPSViewModel.RPSState,
    onChoiceSelect: (RPSOption) -> Unit,
    onSubmit: () -> Unit,
) {
    RPSRow(
        modifier = Modifier.fillMaxSize(),
    ) {
        RPSScrollableColumn(modifier = Modifier.weight(.25f)) {
            // Player Section
            RPSOption.values().forEach {
                // Display a box with Icon and border for each
                RPSOptionCard(
                    onSelect = { onChoiceSelect(it) },
                    option = it,
                    selected = state.playerChoice == it,
                )
            }
        }
        RPSColumn(modifier = Modifier.weight(.25f)) {
            RPSDisplayCard(
                option = state.playerChoice,
                text = R.string.game_player_choice,
            )
        }
        RPSColumn(
            modifier = Modifier.weight(.25f),
        ) {
            // Computer section
            RPSDisplayCard(
                text = R.string.game_computer_choice,
            )
        }
        RPSColumn(modifier = Modifier.weight(.25f)) {
            Button(onClick = onSubmit) {
                Text(text = stringResource(id = R.string.game_submit_button_text))
            }
        }
    }
}
