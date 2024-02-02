package com.fizzbuzz.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun ImageFromUrl(url: String, size: Int = 100) {
    val painter = rememberAsyncImagePainter(model = url)
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .size(
            size.dp,
            size.dp
        ),
        alignment = androidx.compose.ui.Alignment.Center
    )
}

@Composable
fun ImageFromResource(res: Int, size: Int = 100) {
    val painter = rememberAsyncImagePainter(model = res)
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .size(
                size.dp,
                size.dp
            ).clickable {

            },
        alignment = androidx.compose.ui.Alignment.Center
    )
}
