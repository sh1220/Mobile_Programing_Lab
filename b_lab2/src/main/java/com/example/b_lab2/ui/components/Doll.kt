package com.example.b_lab2.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.b_lab2.R
import com.example.b_lab2.model.DollData
import com.example.b_lab2.model.DollListFactory


@Composable
fun Doll(modifier: Modifier = Modifier, dollList: List<DollData>) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Image(
            modifier = modifier,
            painter = painterResource(R.drawable.body),
            contentDescription = "body"
        )
        dollList.forEach { it ->
            if(it.is_checked){
                Image(
                    modifier = modifier,
                    painter = painterResource( it.doll_img),
                    contentDescription = it.doll_description,
                )
            }
        }
    }
}

@Preview
@Composable
private fun DollPreview() {
    val dollList = DollListFactory.dollList()
    Column {
        Doll(dollList = dollList)

    }
}
