package com.fizzbuzz.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fizzbuzz.R


@Composable
fun ButtonAction(
    text: String,
    onClickedButton: () -> Unit = {},
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center),
        onClick = { onClickedButton.invoke() },
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.blue_174)),
        shape = RoundedCornerShape(6.dp)
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = text,
            fontSize = 18.sp,
            color = Color.White,
        )
    }
}


@Composable
fun ActionImageButton(
    image: Int,
    bgColor: Color = Color.Transparent,
    padding: Dp = 4.dp,
    onClickedButton: () -> Unit = {},
) {
    Button(
        border = ButtonDefaults.outlinedButtonBorder,
        onClick = {
            onClickedButton.invoke()
        },
        modifier = Modifier
            .padding(padding)
            .background(color = bgColor)
    ) {
        ImageFromResource(res = image, 24)
    }
}

