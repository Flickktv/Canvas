package com.example.canvas

class CanvasViewModel : BaseViewModel<ViewState>() {
    override fun initialViewState(): ViewState =
        ViewState(colorList = enumValues<COLOR>().map { ToolItem.ColorModel(it.value) })

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        return null
    }

}