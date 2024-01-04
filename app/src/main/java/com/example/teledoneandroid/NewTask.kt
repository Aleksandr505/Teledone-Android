package com.example.teledoneandroid

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun NewTaskLayout(navController: NavController, modifier: Modifier = Modifier) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column (
        modifier = modifier
            .fillMaxSize()
    ) {
        Row {
            Button(onClick = {
                navController.navigate(Screen.MainScreen.route + "?title=" + title)
            }) {
                Text(text = stringResource(R.string.task_save))
            }
        }

        TextField(
            value = title,
            onValueChange = { title = it },
            singleLine = true,
            label = { Text(text = stringResource(R.string.task_title)) }
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text(text = stringResource(R.string.task_description)) }
        )
    }
}