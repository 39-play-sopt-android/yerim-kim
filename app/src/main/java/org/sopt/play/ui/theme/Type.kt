package org.sopt.play.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import org.sopt.play.R

object PretendardFont{
    val Medium = FontFamily(Font(R.font.pretendard_medium))
    val SemiBold = FontFamily(Font(R.font.pretendard_semibold))
    val Bold = FontFamily(Font(R.font.pretendard_bold))
}

sealed interface TypographyTokens {
    @Immutable
    data class Headline(
        val b28: TextStyle,
    ) : TypographyTokens

    @Immutable
    data class Body(
        val m18: TextStyle,
        val sb16: TextStyle,
    ) : TypographyTokens

    @Immutable
    data class Caption(
        val m14: TextStyle,
        val sb14: TextStyle,
    ) : TypographyTokens
}

@Immutable
data class PLAYSOPTTypography(
    val headline: TypographyTokens.Headline,
    val body: TypographyTokens.Body,
    val caption: TypographyTokens.Caption,
)

private fun PLAYSOPTTextStyle(
    fontFamily: FontFamily,
    fontSize: TextUnit,
    fontWeight: FontWeight,
    lineHeight: TextUnit = 1.2.em,
    letterSpacing: TextUnit = (-0.01).em,
): TextStyle = TextStyle(
    fontFamily = fontFamily,
    fontSize = fontSize,
    fontWeight = fontWeight,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing,
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None,
    ),
)

val defaultPLAYSOPTTypography = PLAYSOPTTypography(
    headline = TypographyTokens.Headline(
        b28 = PLAYSOPTTextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
        ),
    ),
    body = TypographyTokens.Body(
        m18 = PLAYSOPTTextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
        ),
        sb16 = PLAYSOPTTextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
        ),
    ),
    caption = TypographyTokens.Caption(
        m14 = PLAYSOPTTextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
        ),
        sb14 = PLAYSOPTTextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
        ),
    ),
)

val LocalPLAYSOPTTypography = staticCompositionLocalOf { defaultPLAYSOPTTypography }
