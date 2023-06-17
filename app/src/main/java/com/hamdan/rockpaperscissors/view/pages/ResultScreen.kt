package com.hamdan.rockpaperscissors.view.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hamdan.rockpaperscissors.R
import com.hamdan.rockpaperscissors.Result
import com.hamdan.rockpaperscissors.view.LocalNavController
import com.hamdan.rockpaperscissors.view.pages.NavigationDestinations.GAME_PAGE
import com.hamdan.rockpaperscissors.view.theme.dimens
import com.hamdan.rockpaperscissors.view.widgets.RPSColumn
import com.hamdan.rockpaperscissors.view.widgets.RPSDisplayCard
import com.hamdan.rockpaperscissors.view.widgets.SubtitleText
import com.hamdan.rockpaperscissors.view.widgets.TitleText
import com.hamdan.rockpaperscissors.viewmodels.RPSViewModel

@Composable
fun ResultScreen(
    state: RPSViewModel.RPSState,
    onScreenTap: () -> Unit,
) {
    if (state.result == Result.NONE) {
        val navigator = LocalNavController.current
        LaunchedEffect(Unit) {
            navigator?.navigate(GAME_PAGE) {
                navigator.popBackStack()
            }
        }
    } else {
        RPSColumn(modifier = Modifier.clickable { onScreenTap() }) {
            when (state.result) {
                Result.WIN -> TitleText(textId = R.string.result_win)
                Result.LOSS -> TitleText(textId = R.string.result_loss)
                Result.TIE -> TitleText(textId = R.string.result_tie)
                Result.NONE -> throw Exception("This should not have been possible")
            }
            SubtitleText(textId = R.string.result_subtitle)
            Spacer(modifier = Modifier.height(MaterialTheme.dimens.grid.x8))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f))
                RPSDisplayCard(option = state.playerChoice)
                Spacer(modifier = Modifier.weight(1f))
                RPSDisplayCard(option = state.computerChoice)
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}
