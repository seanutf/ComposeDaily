package com.seanutf.android.learn.composedaily

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seanutf.android.learn.composedaily.ui.theme.ComposeDailyTheme

class MainActivity : ComponentActivity() {
    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Test()
}

@Composable
fun Test() {
    //RowMultipleText()
    //ColumnMultipleText()
    BoxMultipleText()
}

@Composable
fun ColumnMultipleText() {
    Column(
        //垂直方向居中
        verticalArrangement = Arrangement.Center,
        //水平方向靠右
        horizontalAlignment = Alignment.End
    ){
        Text("Alfred Sisley")
        Text("3 minutes ago")
    }
}

@Composable
fun RowMultipleText() {
    Row(
        //垂直方向居父布局底部
        verticalAlignment = Alignment.Bottom,
        //水平方向靠右
        horizontalArrangement = Arrangement.End
    ){
        Text("Alfred Sisley")
        Text("3 minutes ago")
    }
}

@Composable
fun BoxMultipleText() {
    Box {
        Text("Alfred Sisley")
        Text("3 minutes ago")
    }
}