package com.hamdan.rockpaperscissors.view.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

private const val SMALL_SCREEN_DP_WIDTH = 320

@Composable
fun RPSTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    // dynamicColor: Boolean = true, unsure if we should bother with this
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}

private val NormalGrid = GridDimensionSet(
    4.dp, 8.dp, 12.dp, 16.dp, 20.dp, 24.dp, 28.dp, 32.dp, 36.dp, 40.dp,
    44.dp, 48.dp, 52.dp, 56.dp, 60.dp, 64.dp, 68.dp, 72.dp, 76.dp, 80.dp,
)
private val SmallGrid = GridDimensionSet(
    2.dp, 4.dp, 6.dp, 8.dp, 10.dp, 12.dp, 14.dp, 16.dp, 18.dp, 20.dp,
    22.dp, 24.dp, 26.dp, 28.dp, 30.dp, 32.dp, 34.dp, 36.dp, 38.dp, 40.dp
)

private val NormalIconGrid = IconGridSet(
    20.dp, 40.dp, 60.dp, 80.dp, 100.dp, 120.dp, 140.dp, 160.dp
)

//private val SmallIconGrid = IconGridSet(
//    10.dp, 20.dp, 30.dp, 40.dp, 50.dp, 60.dp, 70.dp, 80.dp
//)

private val BorderGrid = BorderGridDimensionSet(
    1.dp, 2.dp, 3.dp, 4.dp
)

private val StaticGrid =
    NormalGrid // change this if needing a different set of values for static grid

val MaterialTheme.dimens: Dimens
    @Composable
    get() = if (LocalConfiguration.current.screenWidthDp <= SMALL_SCREEN_DP_WIDTH)
        Dimens(
            grid = SmallGrid,
            staticGrid = StaticGrid,
            borderGrid = BorderGrid,
            iconGrid = NormalIconGrid,
            elevation = 2.dp
        ) else
        Dimens(
            grid = NormalGrid,
            staticGrid = StaticGrid,
            borderGrid = BorderGrid,
            iconGrid = NormalIconGrid,
            elevation = 2.dp
        )
