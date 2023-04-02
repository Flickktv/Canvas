package com.example.canvas

data class ViewState(
//    val toolsList: List<ToolItem.ToolModel>,
    val colorList: List<ToolItem.ColorModel>,
//    val sizeList: List<ToolItem.SizeModel>,
//    val canvasViewState: CanvasViewState,
//    val isPaletteVisible: Boolean,
//    val isBrushSizeChangerVisible: Boolean,
//    val isToolsVisible: Boolean
)

sealed class UiEvent() : Event {
    data class onPaletteClicked(val index: Int) : UiEvent()
    data class onColorClick(val index: Int) : UiEvent()
    data class onSizeClick(val index: Int) : UiEvent()
    data class onToolsClick(val index: Int) : UiEvent()
    object OnDrawViewClicked : UiEvent()
    object OnToolbarClicked : UiEvent()
}