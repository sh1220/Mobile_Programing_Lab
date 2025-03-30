package com.example.mylecb.model

import androidx.compose.runtime.mutableStateListOf

object TodoItemFactory {
    fun makeTodoList() = mutableStateListOf(
        Item("모프 공부하기1", "03-18 12:40"),
        Item("모프 공부하기2", "03-18 13:40", TodoStatus.COMPLETED),
        Item("모프 공부하기3", "03-18 14:40", TodoStatus.COMPLETED),
        Item("모프 공부하기4", "03-18 15:40")
    )
}