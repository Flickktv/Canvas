package com.example.canvas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.core.view.isVisible
import com.example.canvas.customview.ui.COLOR
import com.example.canvas.customview.ui.CanvasViewModel
import com.example.canvas.customview.ui.UiEvent
import com.example.canvas.customview.ui.ViewState
import com.example.canvas.tools.ToolItem
import com.example.canvas.tools.ToolsLayout
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    companion object {
        private const val PALETTE = 0
        private const val TOOLS = 1
    }

    private val viewModel: CanvasViewModel by viewModel()

    private var toolsList: List<ToolsLayout> = listOf()

    private val paletteLayout: ToolsLayout by lazy { findViewById(R.id.paletteLayout) }
    private val toolsLayout: ToolsLayout by lazy { findViewById(R.id.toolLayout) }
    private val ivBrush: ImageView by lazy { findViewById(R.id.ivBrush) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolsList = listOf(paletteLayout, toolsLayout)
        viewModel.viewState.observe(this, ::render)

        paletteLayout.setOnClickListener {
            viewModel.processUiEvent(UiEvent.onPaletteClicked(it))
        }
        toolsLayout.setOnClickListener {
            viewModel.processUiEvent(UiEvent.onToolsClick(it))
        }
        ivBrush.setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnToolbarClicked)
        }
    }

    private fun render(viewState: ViewState) {
        with(toolsList[PALETTE]) {
            render(viewState.colorList)
            isVisible = viewState.isPaletteVisible
        }
        with(toolsList[TOOLS]) {
            render(viewState.toolsList)
            isVisible = viewState.isToolsVisible
        }
    }
}