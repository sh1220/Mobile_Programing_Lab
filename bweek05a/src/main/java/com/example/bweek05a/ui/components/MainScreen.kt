package com.example.bweek05a.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bweek05a.viewModel.ImageViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
   imageViewModel : ImageViewModel = viewModel()
) {
    val imagelist = imageViewModel.imageList

    val orientation = LocalConfiguration.current.orientation
    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageList(imagelist)
        }
    } else {
        Row (modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically){
            ImageList(imagelist)

        }

    }


//    var img1 by rememberSaveable(stateSaver = ImageData.imageSaver) {
//        mutableStateOf(
//            ImageData(
//                imageUri = ImageUri.ResImage(R.drawable.img1),
//                buttonType = ButtonType.EMOJI,
//                likes = 50,
//                dislikes = 10
//            )
//        )
//    }
//
//    var img2 by rememberSaveable(stateSaver = ImageData.imageSaver) {
//        mutableStateOf(
//            ImageData(
//                imageUri = ImageUri.ResImage(R.drawable.img2),
//                buttonType = ButtonType.BADGE,
//                likes = 50,
//                dislikes = 10
//            )
//        )
//    }
//
//    var img3 by rememberSaveable(stateSaver = ImageData.imageSaver) {
//        mutableStateOf(
//            ImageData(
//                imageUri = ImageUri.ResImage(R.drawable.img3),
//                buttonType = ButtonType.ICON,
//                likes = 50,
//                dislikes = 10
//            )
//        )
//    }
//
//    Column(
//        modifier= Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        ImageWithButton(image = img1.imageUri) {
//            ButtonWithEmoji(
//                likes = img1.likes,
//                dislikes = img1.dislikes,
//                onClickLikes = {
//                    img1 = img1.copy(likes =  img1.likes + 1) // img1은 불변이라서 +1해서 새로 만들기
//                },
//                onClickDisLikes = {
//                    img1 = img1.copy(dislikes = img1.dislikes + 1)
//                }
//            )
//        }
//
//        ImageWithButton(image = img2.imageUri) {
//            ButtonWithBadge(
//                likes = img2.likes,
//                onClick = {
//                    img2 = img2.copy(likes =  img2.likes + 1) // img1은 불변이라서 +1해서 새로 만들기
//                }
//            )
//        }
//        ImageWithButton(image = img3.imageUri) {
//            ButtonWithIcon(
//                likes = img3.likes,
//                onClick = {
//                    img3 = img3.copy(likes = img3.likes +1)
//                }
//            )
//        }
//      }

}