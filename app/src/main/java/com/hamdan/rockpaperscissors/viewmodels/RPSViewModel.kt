package com.hamdan.rockpaperscissors.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.hamdan.rockpaperscissors.RPSOption
import com.hamdan.rockpaperscissors.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RPSViewModel @Inject constructor() : ViewModel() {
    // I think we can ignore welcome screen, its only there when app first launches
    // for state, we need to know, what user picked and Ai Picked as well as result

    data class RPSState(
        val playerChoice: RPSOption? = null,
        val computerChoice: RPSOption? = null,
        val result: Result = Result.NONE
    )

    val state: MutableState<RPSState> = mutableStateOf(RPSState())

    fun onPlayerSelect(choice: RPSOption) {
        if (state.value.playerChoice == choice) {
            state.value = state.value.copy(playerChoice = null)
        } else {
            state.value = state.value.copy(playerChoice = choice)
        }
    }

    fun onPlayerSubmit() {
        // set the players choice and Computers at the same time,
        // if this needs to be split apart move computer choice out of the copy
        val currentState = state.value
        if (currentState.playerChoice != null) {
            val computerChoice = RPSOption.values().random()
            val lossCases = getLossCases(currentState.playerChoice)
            state.value = state.value.copy(
                playerChoice = currentState.playerChoice,
                computerChoice = computerChoice,
                result = if (computerChoice == currentState.playerChoice) Result.TIE
                else if (lossCases.contains(computerChoice)) Result.LOSS
                else Result.WIN
            )
        }
    }

    fun reset() {
        state.value = state.value.copy(
            playerChoice = null,
            computerChoice = null,
            result = Result.NONE
        )
    }

}

// essentialy acting as a constant of losses
fun getLossCases(choice: RPSOption): List<RPSOption> {
    return when (choice) {
        RPSOption.ROCK -> listOf(
            RPSOption.PAPER,
        )

        RPSOption.PAPER -> listOf(
            RPSOption.SCISSOR
        )

        RPSOption.SCISSOR -> listOf(
            RPSOption.ROCK,
        )

        else -> {
            // if the value isn't on the list it by default loses to every thing else
            RPSOption.values().toList()
        }
    }
}
