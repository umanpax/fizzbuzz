package com.fizzbuzz.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fizzbuzz.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Editable(text: Int, onValueChanged: (TextFieldValue) -> Unit = {}) {
    var textValue by remember { mutableStateOf(TextFieldValue()) }
    Row {
        TextField(
            value = textValue,
            onValueChange = {
                textValue = it
                onValueChanged(it)
            },
            modifier = Modifier
                .background(colorResource(id = R.color.white))
                .padding(16.dp)
                .fillMaxWidth(),
            label = { Text(stringResource(id = text)) }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Editable(label: Int, labelColor: Int, onValueChanged: (String) -> Unit) {
    var textValue by remember { mutableStateOf(TextFieldValue("")) }

    Column {
        TextField(
            value = textValue,
            onValueChange = { newText ->
                if (newText.text.length <= 4) {
                    val stringValue = newText.text
                    textValue = newText
                    onValueChanged(stringValue)
                }
            },
            modifier = Modifier
                .padding(10.dp)
                .width(80.dp)
                .wrapContentHeight() // Hauteur du TextField
                .background(color = colorResource(id = R.color.white)) // Couleur de fond
                .border(
                    1.dp,
                    colorResource(id = R.color.blue_EB7),
                    shape = RoundedCornerShape(4.dp)
                ), // Bordure
            textStyle = androidx.compose.ui.text.TextStyle(
                fontSize = 17.sp,
                color = colorResource(id = labelColor)
            ),
            singleLine = true,
            label = {
                Text(
                    modifier = Modifier.padding(bottom = 4.dp), // Espacement sous le label
                    fontSize = 17.sp,
                    color = colorResource(id = labelColor),
                    text = stringResource(id = label)
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditableInteger(label: Int, labelColor: Int, onValueChanged: (Int) -> Unit) {
    var textValue by remember { mutableStateOf(TextFieldValue("")) }

    Column {
        TextField(
            value = textValue,
            onValueChange = { newText ->
                val newValue = newText.text
                if (newValue.length <= 3) {
                    try {
                        val intValue = if (newValue.isNotEmpty()) newValue.toInt() else 0
                        textValue = newText
                        onValueChanged(intValue)
                    } catch (e: NumberFormatException) {
                        Log.d("NumberFormatException", e.message!!)
                    }
                }
            },
            modifier = Modifier
                .padding(10.dp)
                .width(70.dp)
                .wrapContentHeight()
                .background(color = colorResource(id = R.color.white))
                .border(
                    1.dp,
                    colorResource(id = R.color.blue_EB7),
                    shape = RoundedCornerShape(4.dp)
                ),
            textStyle = androidx.compose.ui.text.TextStyle(
                fontSize = 17.sp,
                color = colorResource(id = labelColor)
            ),
            singleLine = true,
            label = {
                Text(
                    modifier = Modifier.padding(bottom = 4.dp),
                    fontSize = 17.sp,
                    color = colorResource(id = labelColor),
                    text = stringResource(id = label)
                )
            }
        )
    }
}


@Preview
@Composable
fun DisplayEditablePreview() {
    Editable(R.string.app_name)
}

@Preview
@Composable
fun DisplayEditablePreview2() {
    Editable(R.string.app_name, onValueChanged = {

    })
}