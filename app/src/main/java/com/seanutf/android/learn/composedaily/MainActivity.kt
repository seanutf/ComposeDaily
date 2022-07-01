package com.seanutf.android.learn.composedaily

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
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
    TestImg()
}

@Composable
fun TestImg() {
    VectorType()
}

@Composable
fun VectorType() {
    Image(
        imageVector = ImageVector.
        vectorResource(id = R.drawable.icon_phone),
        contentDescription = "icon_phone",
        //动态修改颜色
        colorFilter = ColorFilter.tint(Color(0xFFDA1884)))
}