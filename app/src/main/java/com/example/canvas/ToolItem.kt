package com.example.canvas

import androidx.annotation.ColorRes

sealed class ToolItem : Item {
    data class ColorModel(@ColorRes val color: Int) : ToolItem()
//    data class SizeModel(val size: Int) : ToolItem()
//    data class ToolModel(
//        val type: TOOLS,
//        val selectedTool: TOOLS = TOOLS.NORMAL,
//        val selectedSize: SIZE = SIZE.SMALL,
//        val selectedColor: COLOR = COLOR.BLACK
//        ) : ToolItem()
}