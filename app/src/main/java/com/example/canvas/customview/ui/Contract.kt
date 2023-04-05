package com.example.canvas.customview.ui

import com.example.canvas.base.Event
import com.example.canvas.customview.di.COLOR
import com.example.canvas.customview.di.SIZE
import com.example.canvas.customview.di.TOOLS
import com.example.canvas.tools.ToolItem

data class ViewState(
    val toolsList: List<ToolItem.ToolModel>,
    val colorList: List<ToolItem.ColorModel>,
    val sizeList: List<ToolItem.SizeModel>,
    val canvasViewState: CanvasViewState,
    val isPaletteVisible: Boolean,
    val isBrushSizeChangerVisible: Boolean,
    val isToolsVisible: Boolean
)

sealed class UiEvent() : Event {
    data class onPaletteClicked(val index: Int) : UiEvent()
    data class onColorClick(val index: Int) : UiEvent()
    data class onSizeClick(val index: Int) : UiEvent()
    data class onToolsClick(val index: Int) : UiEvent()
    object OnDrawViewClicked : UiEvent()
    object OnToolbarClicked : UiEvent()
}

sealed class DataEvent() : Event {
    data class onSetDefaultTools(val tools: TOOLS, val color: COLOR, val size: SIZE) : DataEvent()
}