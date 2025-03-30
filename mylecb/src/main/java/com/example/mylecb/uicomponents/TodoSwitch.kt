package com.example.mylecb.uicomponents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TodoSwitch(onlyPending: Boolean, modifier: Modifier = Modifier,onCheckedChange: (Boolean) -> Unit) {
    Row (modifier = modifier.fillMaxWidth().padding(end = 10.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically){
        Text("미완료 항목만 보기")
        Spacer(modifier = Modifier.height(8.dp))
        Switch(checked =  onlyPending,
            onCheckedChange = onCheckedChange
        )
    }
}