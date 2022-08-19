package com.example.coinpaprika.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


fun Modifier.shadowAndBlur(
    color: Color,
    blur: Dp = 0.dp,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    alpha: Float = 0f,
    cornerRadius: Dp = 0.dp,

) = drawBehind {
    drawIntoCanvas {
        val mPaint = Paint()
        mPaint.asFrameworkPaint().color = color.copy(alpha = 0f).toArgb()
        mPaint.asFrameworkPaint().setShadowLayer(
            offsetX.toPx(),
            offsetY.toPx(),
            blur.toPx(),
            color.copy(alpha = alpha).toArgb()
        )
        it.drawRoundRect(
            this.size.width,
            this.size.height,
            0f,
            0f,
            cornerRadius.toPx(),
            cornerRadius.toPx(),
            mPaint
        )
    }
}


@Composable
fun TextWithShadow(
    modifier : Modifier = Modifier,
    text : String,
    color : Color = MaterialTheme.colorScheme.onBackground,
    shadowColor : Color = MaterialTheme.colorScheme.background,
    fontFamily : FontFamily = FontFamily.Default,
    style : TextStyle = MaterialTheme.typography.bodyMedium

){
    Box() {
        Text(text,
            style = style,
            fontFamily = fontFamily,
            color = shadowColor,
            modifier = modifier.offset(0.5.dp, 0.5.dp))
        Text(text,
            style = style,
            fontFamily = fontFamily,
            color = color,
            modifier = modifier)
    }
}