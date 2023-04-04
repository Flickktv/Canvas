package com.example.canvas.tools

import androidx.annotation.ColorRes
import com.example.canvas.customview.ui.COLOR
import com.example.canvas.customview.ui.SIZE
import com.example.canvas.customview.ui.TOOLS

sealed class ToolItem : Item {
    data class ColorModel(@ColorRes val color: Int) : ToolItem()

    //    data class SizeModel(val size: Int) : ToolItem()
    data class ToolModel(
        val type: TOOLS,
        val selectedTool: TOOLS = TOOLS.NORMAL,
//          val selectedSize: SIZE = SIZE.SMALL,
        val selectedColor: COLOR = COLOR.BLACK
    ) : ToolItem()
}