package com.example.displayshape

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.displayshape.ui.theme.DisplayShapeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DisplayShapeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyScreen()
                }
            }
        }
    }
}

@Preview
@Composable
fun MyScreenPreview() {
    MyScreen()
}

@Composable
fun MyScreen() {
    var choice by remember { mutableStateOf(RectangleShape) }
    Column {
        Row(horizontalArrangement = Arrangement.SpaceAround,) {
            Button(
                onClick = { choice = RectangleShape },
                modifier = Modifier
            ) {
                Text("Square")
            }
            Button(
                onClick = { choice = CircleShape }
            ) {
                Text("Circle")
            }
            Button(
                onClick = { choice = RoundedCornerShape(10.dp) }
            ) {
                Text("Rounded Corner")
            }
        }
        ExampleBox(choice)
    }
}

@Composable
fun RectangleShapeDemo(){
    ExampleBox(shape = RectangleShape)
}

@Composable
fun CircleShapeDemo(){
    ExampleBox(shape = CircleShape)
}

@Composable
fun RoundedCornerShapeDemo(){
    ExampleBox(shape = RoundedCornerShape(10.dp))
}

@Composable
fun ExampleBox(shape: androidx.compose.ui.graphics.Shape){
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(shape)
                .background(Color.Red)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DisplayShapeTheme {
        ExampleBox(shape = RectangleShape)
    }
}