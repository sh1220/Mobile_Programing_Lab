package com.example.mylecb.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mylecb.model.Item
import com.example.mylecb.model.TodoItemFactory
import com.example.mylecb.model.TodoStatus

@Composable
fun TodoList(todoList: MutableList<Item>, modifier: Modifier = Modifier, onlyPending: Boolean) {
    val scrollState = rememberScrollState()
    Column(modifier = modifier
        .fillMaxWidth()
        .padding(10.dp)
        .verticalScroll(scrollState)
    ) {
        todoList.withIndex()
            .filter { !(onlyPending && it.value.status == TodoStatus.COMPLETED) }
            .forEach{(index, item) ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TodoCheckBox(isChecked = item.status==TodoStatus.COMPLETED) { status ->
                        todoList[index] = item.copy(
                            status =  if(status) TodoStatus.COMPLETED else TodoStatus.PENDING
                        )
                    }
                    if(!(onlyPending && item.status == TodoStatus.COMPLETED) ) TodoItem(item)

                }
            }
            Spacer(modifier =Modifier.height(8.dp))
        }
    }
}

@Preview
@Composable
private fun TodoListPreview() {
    TodoList(TodoItemFactory.makeTodoList(), onlyPending = true)
    
}