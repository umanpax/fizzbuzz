package com.fizzbuzz.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DialogComponent(
    titleDialog: String,
    textDialog: String,
    positiveButtonText: String,
    negativeButtonText: String,
    positiveButtonAction: () -> Unit,
    negativeButtonAction: () -> Unit,
    isDialogOpen: Boolean
) {
    var displayDialog = isDialogOpen

    if (displayDialog) {
        AlertDialog(
            onDismissRequest = {
                displayDialog = false
            },
            title = { Text(text =  titleDialog) },
            text = { Text(text =  textDialog) },
            confirmButton = {
                ButtonAction(
                    text = positiveButtonText,
                    onClickedButton = {
                        positiveButtonAction.invoke()
                        displayDialog = false
                    }
                )
            },
            dismissButton = {
                ButtonAction(
                    text = negativeButtonText,
                    onClickedButton = {
                        negativeButtonAction.invoke()
                        displayDialog = false
                    }
                )
            }
        )
    }
}



