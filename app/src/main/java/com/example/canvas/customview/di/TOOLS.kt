package com.example.canvas.customview.di

import androidx.annotation.DrawableRes
import com.example.canvas.R

enum class TOOLS(
    @DrawableRes
    val value: Int
) {

    NORMAL(R.drawable.baseline_brightness_1_24),
    DASH(R.drawable.dashed_line),
    SIZE(R.drawable.baseline_blur_linear_24),
    PALETTE(R.drawable.baseline_brightness_1_24),

}