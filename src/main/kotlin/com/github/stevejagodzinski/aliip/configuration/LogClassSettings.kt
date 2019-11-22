package com.github.stevejagodzinski.aliip.configuration

import com.intellij.ide.util.PropertiesComponent
import com.intellij.openapi.project.Project

class LogClassSettings(protect: Project) {
    companion object {
        const val KEY = "com.github.stevejagodzinski.aliip.configuration.logClass"
    }

    private val propertiesComponent = PropertiesComponent.getInstance(protect)

    fun getLogClass(): String? {
        return propertiesComponent.getValue(KEY)
    }

    fun setLogClass(value: String?) {
        propertiesComponent.setValue(KEY, value)
    }
}
