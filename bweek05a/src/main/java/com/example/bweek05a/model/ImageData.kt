package com.example.bweek05a.model

import androidx.compose.runtime.saveable.listSaver


data class ImageData(
    val imageUri: ImageUri,
    val buttonType: ButtonType = ButtonType.ICON,
    val likes: Int = 0,
    val dislikes: Int = 0,
) {
    companion object {
        val imageSaver = listSaver<ImageData, Any>(
            save = { item ->
                listOf(
                    when (item.imageUri) {
                        is ImageUri.ResImage -> item.imageUri.resID // is로 인해 바로 item이 ImageUri.ResImage가 됨.
                        is ImageUri.WebImage -> item.imageUri.urlStr
                    },
                    item.buttonType.name,
                    item.likes,
                    item.dislikes
                )
            },
            restore = {list ->
                val img = when(val  imgValue = list[0]){
                    is Int -> ImageUri.ResImage(imgValue)
                    is String  -> ImageUri.WebImage(imgValue)
                    else -> throw IllegalArgumentException("타입 오류")
                }
                ImageData(
                    img,
                    ButtonType.valueOf(list[1] as String),
                    list[2] as Int,
                    list[3] as Int
                )
            }

        )
    }
}

