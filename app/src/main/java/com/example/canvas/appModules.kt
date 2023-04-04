package com.example.canvas

import com.example.canvas.customview.ui.CanvasViewModel
import com.example.canvas.customview.ui.CanvasViewState
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val module = module {
    viewModel {
        CanvasViewModel()
    }
}