package com.fizzbuzz.features.fizzbuzz.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.fizzbuzz.R
import com.fizzbuzz.components.ButtonAction
import com.fizzbuzz.components.Editable
import com.fizzbuzz.components.EditableInteger
import com.fizzbuzz.features.fizzbuzz.states.FizzBuzzViewState
import com.fizzbuzz.features.fizzbuzz.viewmodels.FizzBuzzViewModel
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FizzBuzzScreen(
    viewModel: FizzBuzzViewModel = getViewModel()
) {

    val keyboardController = LocalSoftwareKeyboardController.current
    val viewState: FizzBuzzViewState by viewModel.getViewState().collectAsStateWithLifecycle()
    val context = LocalContext.current

    var int1 by remember { mutableStateOf(0) }
    var int2 by remember { mutableStateOf(0) }
    var limit by remember { mutableStateOf(0) }
    var str1 by remember { mutableStateOf("") }
    var str2 by remember { mutableStateOf("") }


    Column(modifier = Modifier.fillMaxWidth()) {


        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.TopCenter),
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                fontFamily = FontFamily.Monospace,
                color = colorResource(id = R.color.blue_EB7)
            )
        )


        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        ) {

            EditableInteger(
                label = R.string.int1,
                labelColor = R.color.blue_EB7,
                limit = 3,
                onValueChanged = {
                    int1 = it
                }
            )

            EditableInteger(
                label = R.string.int2,
                labelColor = R.color.blue_EB7,
                limit = 3,
                onValueChanged = {
                    int2 = it
                }
            )

            EditableInteger(
                label = R.string.limit,
                labelColor = R.color.blue_EB7,
                limit = 4,
                onValueChanged = {
                    limit = it
                }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        ) {

            Editable(
                label = R.string.str1,
                labelColor = R.color.blue_EB7,
                limit = 4,
                onValueChanged = {
                    str1 = it
                }

            )

            Editable(
                label = R.string.str2,
                labelColor = R.color.blue_EB7,
                limit = 4,
                onValueChanged = {
                    str2 = it
                }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        ButtonAction(text = stringResource(
            id = R.string.generate
        ),
            onClickedButton = {
                if (int1 != 0 && int2 != 0 && limit != 0 && str1.isNotEmpty() && str2.isNotEmpty()) {
                    keyboardController?.hide()
                    viewModel.getFizzBuzzList(
                        int1 = int1,
                        int2 = int2,
                        limit = limit,
                        str1 = str1,
                        str2 = str2
                    )
                } else {
                    Toast.makeText(
                        context,
                       context.getText(R.string.err_msg),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })

        Spacer(modifier = Modifier.height(16.dp))

        if (viewState.fizzBuzzList.isNotEmpty()) {
            ListFizzBuzz(
                items = viewState.fizzBuzzList
            )
        } else if (viewState.error.isNotEmpty()) {
            Toast.makeText(context, viewState.error, Toast.LENGTH_SHORT)
                .show()
        }

        if (viewState.error.isNotEmpty()) {
            Toast.makeText(context, viewState.error, Toast.LENGTH_LONG).show()
        }
    }
}

@Composable
fun ListFizzBuzz(
    items: List<String>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(450.dp)
            .wrapContentSize(Alignment.Center)
    ) {
        itemsIndexed(items) { index, item ->
            ItemFizzBuzz(item)
        }
    }
}


@Composable
fun ItemFizzBuzz(
    item: String
) {
    Card(
        modifier = Modifier
            .background(colorResource(id = R.color.white))
            .width(350.dp)
            .wrapContentHeight()
            .padding(8.dp),
    ) {
        Text(
            text = item,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.TopCenter),
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 20.sp,
                fontFamily = FontFamily.Monospace,
                color = colorResource(id = R.color.blue_EB7)
            )
        )
    }
}




