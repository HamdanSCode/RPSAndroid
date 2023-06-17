package com.hamdan.rockpaperscissors.view.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    bodyLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    bodySmall = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    headlineLarge = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 48.sp,
    ),
    headlineMedium = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 32.sp,
    ),
    headlineSmall = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
    )
)

val Typography.headlineLargeBold: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 48.sp,
    )

val Typography.headlineMediumBold: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 32.sp,
    )

val Typography.headlineSmallBold: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize = 24.sp,
    )

val Typography.bodyLargeBold: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
    )

val Typography.bodyMediumBold: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
    )

val Typography.bodySmallBold: TextStyle
    get() = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
    )
