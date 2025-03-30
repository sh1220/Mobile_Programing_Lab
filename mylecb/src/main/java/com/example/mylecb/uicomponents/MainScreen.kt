package com.example.mylecb.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mylecb.model.TodoItemFactory

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val todoList = remember { TodoItemFactory.makeTodoList() }
    var onlyPending by remember { mutableStateOf(false) }

    Column (modifier = Modifier.fillMaxSize().padding(vertical = 10.dp)){
        TodoListTitle(modifier = Modifier.padding(start = 10.dp))
        Spacer(modifier = Modifier.height(8.dp))

        TodoSwitch(onlyPending){ onlyPending = it }
        Spacer(modifier = Modifier.height(8.dp))

        TodoList(todoList, Modifier.weight(1f), onlyPending)
        Spacer(modifier = Modifier.height(8.dp))

        TodoItemInput(todoList)
    }

}