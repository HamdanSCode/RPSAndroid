package com.hamdan.rockpaperscissors.view.theme

import androidx.compose.ui.unit.Dp

data class Dimens(
    val grid: GridDimensionSet,
    val staticGrid: GridDimensionSet,
    val borderGrid: BorderGridDimensionSet, //this is always static
    val iconGrid: IconGridSet,
    val elevation: Dp,
)

data class GridDimensionSet(
    val x1: Dp,
    val x2: Dp,
    val x3: Dp,
    val x4: Dp,
    val x5: Dp,
    val x6: Dp,
    val x7: Dp,
    val x8: Dp,
    val x9: Dp,
    val x10: Dp,
    val x11: Dp,
    val x12: Dp,
    val x13: Dp,
    val x14: Dp,
    val x15: Dp,
    val x16: Dp,
    val x17: Dp,
    val x18: Dp,
    val x19: Dp,
    val x20: Dp,
)

data class BorderGridDimensionSet(
    val x1: Dp,
    val x2: Dp,
    val x3: Dp,
    val x4: Dp,
)

data class IconGridSet(
    val x1: Dp,
    val x2: Dp,
    val x3: Dp,
    val x4: Dp,
    val x5: Dp,
    val x6: Dp,
    val x7: Dp,
    val x8: Dp,
)
