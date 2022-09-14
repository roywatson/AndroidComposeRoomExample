/*
Copyright (C) 2022 Roy Watson

Permission is hereby granted, free of charge, to any person obtaining a copy of this
software and associated documentation files (the "Software"), to deal in the Software
without restriction, including without limitation the rights to use, copy, modify, merge,
publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons
to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies
or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
OR OTHER DEALINGS IN THE SOFTWARE.
*/
package com.delasystems.androidcomposeroomexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.delasystems.androidcomposeroomexample.ui.misc.Attribution
import com.delasystems.androidcomposeroomexample.ui.theme.AndroidComposeRoomExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomApp()
        }
    }
}

@Composable
private fun RoomApp() {
    val viewModel: MainViewModel = viewModel()
    RoomMainScreen(
        modifier = Modifier.fillMaxSize(),
        viewModel
    )
}


@Composable
private fun RoomMainScreen(
    modifier: Modifier,
    viewModel: MainViewModel
) {
    AndroidComposeRoomExampleTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentHeight()
                    .padding(5.dp)
            ) {
                Attribution()
                Button(
                    content = { Text("Insert Looping") },
                    onClick = { viewModel.insertLooping() }
                )
                Button(
                    content = { Text("Insert Location List") },
                    onClick = { viewModel.insertLocationList() }
                )
                Button(
                    content = { Text("Transaction Example") },
                    onClick = { viewModel.saveTransaction() }
                )
                Button(
                    content = { Text("Cascading Delete Example") },
                    onClick = { viewModel.cascadingDeleteExample() }
                )
                Button(
                    content = { Text("Get first pet at BTV") },
                    onClick = { viewModel.findFirstPetAt("Burlington", "VT") }
                )
                Text(
                    modifier = Modifier.padding(start = 0.dp, top = 10.dp, end = 0.dp, bottom = 0.dp),
                    text = viewModel.resultState.value,
                    fontSize = 20.sp,
                )
            }
        }
    }
}

