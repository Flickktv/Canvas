package com.example.canvas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.view.isVisible
import com.example.canvas.customview.ui.*
import com.example.canvas.tools.ToolsLayout
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    companion object {
        private const val PALETTE_VIEW = 0
        private const val TOOLS_VIEW = 1
        private const val SIZE_VIEW = 2
    }

    private val viewModel: CanvasViewModel by viewModel()

    private var toolsList: List<ToolsLayout> = listOf()

    private val paletteLayout: ToolsLayout by lazy { findViewById(R.id.paletteLayout) }
    private val toolsLayout: ToolsLayout by lazy { findViewById(R.id.toolLayout) }
    private val sizeLayout: ToolsLayout by lazy { findViewById(R.id.sizeLayout) }
    private val ivBrush: ImageView by lazy { findViewById(R.id.ivBrush) }
    private val drawView: DrawView by lazy { findViewById(R.id.viewDraw) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolsList = listOf(paletteLayout, toolsLayout, sizeLayout)
        viewModel.viewState.observe(this, ::render)

        paletteLayout.setOnClickListener {
            viewModel.processUiEvent(UiEvent.onPaletteClicked(it))
        }
        toolsLayout.setOnClickListener {
            viewModel.processUiEvent(UiEvent.onToolsClick(it))
        }
        sizeLayout.setOnClickListener {
            viewModel.processUiEvent(UiEvent.onSizeClick(it))
        }
        ivBrush.setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnToolbarClicked)
        }

    }

    private fun render(viewState: ViewState) {
        with(toolsList[PALETTE_VIEW]) {
            render(viewState.colorList)
            isVisible = viewState.isPaletteVisible
        }
        with(toolsList[TOOLS_VIEW]) {
            render(viewState.toolsList)
            isVisible = viewState.isToolsVisible
        }
        with(toolsList[SIZE_VIEW]) {
            render(viewState.sizeList)
            isVisible = viewState.isBrushSizeChangerVisible
        }
        drawView.render(viewState.canvasViewState)
    }
}