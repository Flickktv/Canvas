package com.example.canvas

import android.graphics.PorterDuff
import android.widget.ImageView
import com.example.canvas.customview.ui.TOOLS
import com.example.canvas.tools.Item
import com.example.canvas.tools.ToolItem
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateLayoutContainer

fun colorAdapterDelegate(
    onClick: (Int) -> Unit
): AdapterDelegate<List<Item>> =
    adapterDelegateLayoutContainer<ToolItem.ColorModel, Item>(
        R.layout.item_palette
    ) {
        val color: ImageView = findViewById(R.id.color)
        itemView.setOnClickListener { onClick(adapterPosition) }
        bind {list ->
            color.setColorFilter(
                context.resources.getColor(item.color, null),
                PorterDuff.Mode.SRC_IN
            )
        }
    }

fun toolsAdapterDelegate(
    onToolsClick: (Int) -> Unit
): AdapterDelegate<List<Item>> = adapterDelegateLayoutContainer<ToolItem.ToolModel, Item>(
    R.layout.layout_tools
) {

    val ivTool: ImageView = findViewById(R.id.ivTools)
    bind {list ->
        ivTool.setImageResource(item.type.value)

        when (item.type) {
            TOOLS.NORMAL -> {
                if (item.selectedTool == TOOLS.NORMAL) {
                    ivTool.setBackgroundResource(R.drawable.color_background)
                } else{
                    ivTool.setBackgroundResource(android.R.color.transparent)
                }
            }
            TOOLS.DASH -> {
                if (item.selectedTool == TOOLS.DASH) {
                    ivTool.setBackgroundResource(R.drawable.color_background)
                } else {
                    ivTool.setBackgroundResource(android.R.color.transparent)
                }
            }
            TOOLS.PALETTE -> {
                ivTool.setColorFilter(
                    context.resources.getColor(item.selectedColor.value, null),
                    PorterDuff.Mode.SRC_IN
                )
            }
        }

        itemView.setOnClickListener {
            onToolsClick(adapterPosition)
        }
    }
}