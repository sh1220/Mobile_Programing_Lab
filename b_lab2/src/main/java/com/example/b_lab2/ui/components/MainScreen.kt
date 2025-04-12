package com.example.b_lab2.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.b_lab2.model.DollData
import com.example.b_lab2.model.DollListFactory

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val orientation = LocalConfiguration.current.orientation
    val dollList = rememberSaveable(saver = DollData.dollSaver) { DollListFactory.dollList()}

    if(orientation == Configuration.ORIENTATION_PORTRAIT){
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier.height(50.dp))
            Doll(modifier = modifier.size(300.dp), dollList = dollList)
            Buttons(dollList = dollList)
        }

    } else {
        Row(
            modifier = modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Doll(modifier = modifier.size(300.dp), dollList = dollList)
            Buttons(dollList = dollList)
        }

    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}