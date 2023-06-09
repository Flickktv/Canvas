package com.example.canvas.customview.di

enum class SIZE(
    val value: Int
) {

    SMALL(4),
    MEDIUM(16),
    LARGE(32);

    companion object {
        private val map = values().associateBy(SIZE::value)
        fun from(color: Int) = map[color] ?: SMALL
    }
}