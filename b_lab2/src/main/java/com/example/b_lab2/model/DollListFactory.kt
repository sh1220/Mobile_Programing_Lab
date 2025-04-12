package com.example.b_lab2.model

import androidx.compose.runtime.mutableStateListOf
import com.example.b_lab2.R

object DollListFactory {
    fun dollList() = mutableStateListOf(
        DollData(R.drawable.arms,"arms"),
        DollData(R.drawable.ears,"ears"),
        DollData(R.drawable.eyebrows,"eyebrows"),
        DollData(R.drawable.eyes,"eyes"),
        DollData(R.drawable.glasses,"glasses"),
        DollData(R.drawable.hat,"hat"),
        DollData(R.drawable.mouth,"mouth"),
        DollData(R.drawable.mustache,"mustache"),
        DollData(R.drawable.nose,"nose"),
        DollData(R.drawable.shoes,"shoes")
    )
}