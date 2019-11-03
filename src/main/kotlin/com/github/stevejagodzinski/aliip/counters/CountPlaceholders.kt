package com.github.stevejagodzinski.aliip.counters

object CountPlaceholders {
    fun countPlaceholders(template: String): Int {
        return template.split("{}").size - 1
    }
}