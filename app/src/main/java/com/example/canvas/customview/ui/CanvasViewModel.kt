package com.example.canvas.customview.ui

import com.example.canvas.base.BaseViewModel
import com.example.canvas.base.Event
import com.example.canvas.customview.di.COLOR
import com.example.canvas.customview.di.SIZE
import com.example.canvas.customview.di.TOOLS
import com.example.canvas.tools.ToolItem

class CanvasViewModel : BaseViewModel<ViewState>() {
    override fun initialViewState(): ViewState =
        ViewState(
            colorList = enumValues<COLOR>().map { ToolItem.ColorModel(it.value) },
            toolsList = enumValues<TOOLS>().map { ToolItem.ToolModel(it) },
            sizeList = enumValues<SIZE>().map { ToolItem.SizeModel(it.value) },
            isPaletteVisible = false,
            isToolsVisible = false,
            isBrushSizeChangerVisible = false,
            canvasViewState = CanvasViewState(color = COLOR.BLACK, tools = TOOLS.NORMAL, size = SIZE.MEDIUM)
        )

    init {
        processDataEvent(DataEvent.onSetDefaultTools(tools = TOOLS.NORMAL, color = COLOR.BLACK, size = SIZE.MEDIUM))
    }

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {

            is UiEvent.OnToolbarClicked -> {
                return previousState.copy(
                    isToolsVisible = !previousState.isToolsVisible,
                    isPaletteVisible = false,
                    isBrushSizeChangerVisible = false
                )
            }

            is UiEvent.onToolsClick -> {
                when (event.index) {
                    TOOLS.PALETTE.ordinal -> {
                        return previousState.copy(isPaletteVisible = !previousState.isPaletteVisible)
                    }
                    TOOLS.SIZE.ordinal -> {
                        return previousState.copy(isBrushSizeChangerVisible = !previousState.isBrushSizeChangerVisible)
                    }
                    else -> {
                        val toolsList = previousState.toolsList.mapIndexed() { index, model ->
                            if (index == event.index) {
                                model.copy(isSelected = true)
                            } else {
                                model.copy(isSelected = false)
                            }
                        }
                        return previousState.copy(
                            toolsList = toolsList,
                            canvasViewState = previousState.canvasViewState.copy(tools = TOOLS.values()[event.index])
                        )
                    }
                }
            }

            is UiEvent.onPaletteClicked -> {
                val selectedColor = COLOR.values()[event.index]
                val toolsList = previousState.toolsList.map {
                    if (it.type == TOOLS.PALETTE) {
                        it.copy(selectedColor = selectedColor)
                    } else {
                        it
                    }
                }
                return previousState.copy(
                    toolsList = toolsList,
                    canvasViewState = previousState.canvasViewState.copy(color = selectedColor)
                )
            }

            is UiEvent.onSizeClick -> {
                val selectedSize = SIZE.values()[event.index]
                val toolsList = previousState.toolsList.map {
                    if (it.type == TOOLS.SIZE) {
                        it.copy(selectedSize = selectedSize)
                    } else {
                        it
                    }
                }
                return previousState.copy(
                    toolsList = toolsList,
                    canvasViewState = previousState.canvasViewState.copy(size = selectedSize)
                )
            }

            is DataEvent.onSetDefaultTools -> {
                val toolsList = previousState.toolsList.map { model ->
                    if (model.type == event.tools) {
                        model.copy(isSelected = true, selectedColor = event.color, selectedSize = event.size)
                    } else {
                        model.copy(isSelected = false)
                    }
                }
                return previousState.copy(
                    toolsList = toolsList
                )
            }
            else -> return null
        }
    }
}