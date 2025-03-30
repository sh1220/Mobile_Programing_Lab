package com.example.mylecb.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mylecb.model.Item
import com.example.mylecb.model.TodoItemFactory
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun TodoItemInput(todoList:MutableList<Item>,modifier: Modifier = Modifier) {
    var textfieldState by remember {
        mutableStateOf("")
    }
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        TextField(value = textfieldState,
            onValueChange = {content -> textfieldState = content},
            placeholder = {Text("할 일을 입력하세요.")}
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = {
            todoList.add(Item(
                textfieldState,
                LocalDateTime
                    .now()
                    .format(DateTimeFormatter.ofPattern("MM-dd HH:mm"))
            ))
            textfieldState = ""
        }) {
            Text("추가")
        }
    }
}

@Preview
@Composable
private fun TodoItemInputPreview() {
    TodoItemInput(TodoItemFactory.makeTodoList())

}