package com.fizzbuzz.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
    fun TextWithActionButtons(
        text: String,
        onClickedText: () -> Unit = {},
        textButton1: Int,
        textButton2: Int? = null,
        textButton3: Int? = null,
        onClickedButton1: () -> Unit = {},
        onClickedButton2: () -> Unit = {},
        onClickedButton3: () -> Unit = {}
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(2.dp)
                .background(Color.DarkGray)
        ) {
            Text(
                color = Color.White,
                text = text,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(12.dp, 4.dp, 4.dp, 4.dp)
                    .clickable(onClick = onClickedText)
                    .width(180.dp)
                )

            Spacer(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.DarkGray)
            )

            ButtonAction(text = stringResource(id = textButton1), onClickedButton = onClickedButton1)
            if (textButton2 != null) {
                ButtonAction(text = stringResource(textButton2), onClickedButton = onClickedButton2)
            }
            if (textButton3 != null) {
                ButtonAction(text = stringResource(textButton3), onClickedButton = onClickedButton3)
            }
        }
    }

