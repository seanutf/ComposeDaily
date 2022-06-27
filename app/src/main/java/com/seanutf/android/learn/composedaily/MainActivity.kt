package com.seanutf.android.learn.composedaily

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seanutf.android.learn.composedaily.ui.theme.ComposeDailyTheme

class MainActivity : ComponentActivity() {
    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test1()
        }
    }
}

@Composable
fun Greeting(name: String) {
    //Text(text = "Hello $name!")
    BasicText(
        text = "Helo $name!",
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Test()
}

@Composable
fun Test() {

    var count by remember { mutableStateOf(0) }
    ClickCounter(count) {
        count += 1
    }
}

@Composable
fun Test1() {
    var count by remember { mutableStateOf(0) }
    Button(onClick = { count += 1 }) {
        Text("I've been clicked $count times")
    }
}

@Composable
fun ClickCounter(clicks: Int, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text("I've been clicked $clicks times")
    }
}