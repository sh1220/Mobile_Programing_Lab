package com.example.b_lab2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.b_lab2.model.DollData
import com.example.b_lab2.model.DollListFactory

@Composable
fun Buttons(modifier: Modifier = Modifier, dollList: MutableList<DollData>) {
    Column(modifier = modifier.fillMaxWidth()) {
        for (i in 0..<dollList.size step 2) {
            Row(modifier = modifier.fillMaxWidth()
            ) {
                Button(
                    modifier = modifier.weight(0.5f),
                    dollData = dollList[i]
                ) { isChecked ->
                    dollList[i] = dollList[i].copy(is_checked = !dollList[i].is_checked)
                }
                Button(
                    modifier = modifier.weight(0.5f),
                    dollData = dollList[i + 1]
                ) { isChecked ->
                    dollList[i + 1] = dollList[i+1].copy(is_checked = !dollList[i + 1].is_checked)
                }
            }
        }
        Text("202312350 박성현", modifier = modifier.fillMaxWidth(), textAlign = TextAlign.Center)

    }
}

@Composable
fun Button(modifier: Modifier = Modifier, dollData: DollData, onChanged: ((Boolean) -> Unit)) {
    Row(modifier = modifier.padding(start = 40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Checkbox(
            checked = dollData.is_checked,
            onCheckedChange = onChanged
        )
        Text(
            text = dollData.doll_description
        )
    }
}


@Preview
@Composable
private fun ButtonPreview() {
    val dollList = rememberSaveable(saver = DollData.dollSaver) { DollListFactory.dollList() }
    Buttons(dollList = dollList)

}