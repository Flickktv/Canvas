package com.example.canvas.customview.ui

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.example.canvas.R

data class CanvasViewState(val color: COLOR, val size: SIZE, val tools: TOOLS)

enum class COLOR(
    @ColorRes
    val value: Int
) {

    BLACK(R.color.black),
    RED(R.color.purple_500),
    BLUE(R.color.purple_700);

    companion object {
        private val map = values().associateBy(COLOR::value)
        fun from(color: Int) = map[color] ?: BLACK
    }
}

enum class SIZE(
    val value: Int
) {

    SMALL(4),
    MEDIUM(16),
    LARGE(32);

    companion object {
        private val map = values().associateBy(SIZE::value)
        fun from(color: Int) = map[color] ?: SMALL
    }
}

enum class TOOLS(
    @DrawableRes
    val value: Int
) {

    NORMAL(R.drawable.baseline_brightness_1_24),
    DASH(R.drawable.dashed_line),
//    SIZE(R.drawable.baseline_brightness_1_24),
    PALETTE(R.drawable.baseline_brightness_1_24),

}