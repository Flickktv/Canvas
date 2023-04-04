package com.example.canvas.customview.ui

import com.example.canvas.base.BaseViewModel
import com.example.canvas.base.Event
import com.example.canvas.tools.ToolItem

class CanvasViewModel : BaseViewModel<ViewState>() {
    override fun initialViewState(): ViewState =
        ViewState(
            colorList = enumValues<COLOR>().map { ToolItem.ColorModel(it.value) },
            toolsList = enumValues<TOOLS>().map { ToolItem.ToolModel(it) },
            isPaletteVisible = false,
            isToolsVisible = false
        )

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {

            UiEvent.OnToolbarClicked -> {
                return previousState.copy(isToolsVisible = true)
            }
            else -> return null
        }
    }
}