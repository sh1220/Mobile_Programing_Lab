package com.example.b_lab2.model

import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList

data class DollData(
    val doll_img: Int,
    val doll_description: String,
    val is_checked: Boolean = true
) {
    companion object {
        val dollSaver = listSaver<SnapshotStateList<DollData>, Any>(
            save = { list ->
                list.flatMap {
                    listOf(it.doll_img, it.doll_description, it.is_checked)
                }
            },
            restore = { flat ->
                flat.chunked(3).map {(img, description, is_checked)->
                    DollData(img as Int, description as String, is_checked as Boolean)
                }.toMutableStateList()
            }
        )

    }
}
