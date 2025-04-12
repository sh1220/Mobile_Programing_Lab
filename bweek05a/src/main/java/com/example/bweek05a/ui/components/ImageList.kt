package com.example.bweek05a.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bweek05a.model.ButtonType
import com.example.bweek05a.model.ImageData

@Composable
fun ImageList(
    imageList : MutableList<ImageData>,
    modifier: Modifier = Modifier
) {
    imageList.forEachIndexed { index, item -> // item은 immutable 객체
        when(item.buttonType){
            ButtonType.ICON -> {
                ImageWithButton(image = item.imageUri){
                    ButtonWithIcon(
                        likes = item.likes,
                        onClick = {
                            imageList[index] = item.copy(likes = item.likes +1)
                        }
                    )
                }

            }
            ButtonType.BADGE -> {
                ImageWithButton(image = item.imageUri) {
                    ButtonWithBadge(
                        likes = item.likes,
                        onClick = {
                            imageList[index] =
                                item.copy(likes = item.likes + 1) // img1은 불변이라서 +1해서 새로 만들기
                        }
                    )
                }
            }
            ButtonType.EMOJI -> {
                ImageWithButton(image = item.imageUri) {
                    ButtonWithEmoji(
                        likes = item.likes,
                        dislikes = item.dislikes,
                        onClickLikes = {
                            imageList[index] =
                                item.copy(likes = item.likes + 1) // img1은 불변이라서 +1해서 새로 만들기
                        },
                        onClickDisLikes = {
                            imageList[index] = item.copy(dislikes = item.dislikes + 1)
                        }
                    )
                }
            }
        }
    }

}