package com.example.woofapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.woofapp.R

val AbrilFatfase = FontFamily(
    Font(R.font.abrilfatface_regular)
)
val Darumadropone = FontFamily(
    Font(R.font.darumadropone_regular)
)
// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Darumadropone,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    displayMedium = TextStyle(
        fontFamily = Darumadropone,
        fontWeight = FontWeight.Normal,
        fontSize = 25.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = AbrilFatfase,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp
    )
)