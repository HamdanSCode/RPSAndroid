package com.hamdan.rockpaperscissors.view

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hamdan.rockpaperscissors.Result
import com.hamdan.rockpaperscissors.view.pages.GameScreen
import com.hamdan.rockpaperscissors.view.pages.HomeScreen
import com.hamdan.rockpaperscissors.view.pages.NavigationDestinations.GAME_PAGE
import com.hamdan.rockpaperscissors.view.pages.NavigationDestinations.HOME_PAGE
import com.hamdan.rockpaperscissors.view.pages.NavigationDestinations.RESULT_PAGE
import com.hamdan.rockpaperscissors.view.pages.ResultScreen
import com.hamdan.rockpaperscissors.view.theme.RPSTheme
import com.hamdan.rockpaperscissors.viewmodels.RPSViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val model: RPSViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RPSTheme {
                val navController = rememberNavController()
                CompositionLocalProvider(LocalNavController provides navController) {
                    NavHost(
                        navController = navController,
                        startDestination = HOME_PAGE,
                    ) {
                        composable(HOME_PAGE) {
                            HomeScreen(
                                onScreenPress = {
                                    navController.navigate(GAME_PAGE) {
                                        navController.popBackStack()
                                    }
                                }
                            )
                        }
                        composable(GAME_PAGE) {
                            val orientation =
                                remember { mutableStateOf(resources.configuration.orientation) }
                            GameScreen(
                                orientation = orientation.value == Configuration.ORIENTATION_LANDSCAPE,
                                state = model.state.value,
                                onChoiceSelect = {
                                    model.onPlayerSelect(it)
                                },
                                onSubmit = {
                                    model.onPlayerSubmit()
                                }
                            )
                            LaunchedEffect(model.state.value.result) {
                                if (model.state.value.result != Result.NONE) {
                                    navController.navigate(RESULT_PAGE) {
                                        navController.popBackStack()
                                    }
                                }
                            }
                        }
                        composable(RESULT_PAGE) {
                            ResultScreen(
                                state = model.state.value,
                                onScreenTap = {
                                    model.reset()
                                    // navigating inside the compose for resultscreen
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
