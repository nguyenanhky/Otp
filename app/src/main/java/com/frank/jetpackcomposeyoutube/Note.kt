package com.frank.jetpackcomposeyoutube

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * BasicTextField
 */
@Composable
fun BasicTextFieldExample(modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .fillMaxWidth()
        .height(35.dp)) {
        var textValue by remember { mutableStateOf(TextFieldValue()) }

        BasicTextField(
            value = textValue,
            onValueChange = {value->
                Log.d("fpt", "$value ")
                textValue = value
            },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(fontSize = 18.sp)
        )

    }
}

/**
 * function lambla
 */

@Composable
fun DemoFunctionOnParam(onButtonClick:()->Unit, modifier:Modifier = Modifier){
    Box(modifier = modifier){
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Sử dụng Button và truyền hàm onButtonClick làm tham số
            Button(
                onClick = {
                    onButtonClick() // Gọi hàm được truyền vào khi nút được nhấn
                },
                content = {
                    Text("Nhấn vào tôi")
                }
            )
        }
    }
}

/**
 * FocusRequest
 */
@Composable
fun FocusRequesterDemo() {
    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }

    // Tạo hai FocusRequester
    val focusRequester1 = remember { FocusRequester() }
    val focusRequester2 = remember { FocusRequester() }

    Column {
        BasicTextField(
            value = text1,
            onValueChange = {
                text1 = it
            },
            modifier = Modifier
                .focusRequester(focusRequester1) // Khi gọi focusRequester1.requestFocus(), ô văn bản này sẽ nhận focus
                .padding(16.dp)
        )

        BasicTextField(
            value = text2,
            onValueChange = {
                text2 = it
            },
            modifier = Modifier
                .focusRequester(focusRequester2) // Khi gọi focusRequester2.requestFocus(), ô văn bản này sẽ nhận focus
                .padding(16.dp)
        )

        Button(
            onClick = {
                // Yêu cầu focus vào ô văn bản 2 khi nút được nhấn
                focusRequester2.requestFocus()
            },
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text("Nhấn để chuyển focus")
        }
    }
}

/**
 * learn state
 */

@Composable
fun Counter() {
    // Khởi tạo một State với giá trị ban đầu là 0
    var count by remember { mutableStateOf(0) }

    Log.d("kynv1", "Counter: ")
    CounterStateLess()
    Column {
        // Hiển thị giá trị của biến State (count)
        Text(text = "Số lần nhấn: $count")

        // Button để tăng giá trị State count lên 1
        Button(
            onClick = {
                count++
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Tăng số")
        }
    }
}

@Composable
fun CounterStateLess() {
    Log.d("kynv1", "CounterStateLess: ")
}

/**
 * preview screens
 */
@Preview(showBackground = true)
@Composable
fun BasicTextFieldExamplePreview(){
    BasicTextFieldExample()
}

@Preview(showBackground = true)
@Composable
fun DemoFunctionOnParamPreview(){
    DemoFunctionOnParam(onButtonClick = { /*TODO*/ })
}

@Preview(showBackground = true)
@Composable
fun CounterPreview(){
    Counter()
}