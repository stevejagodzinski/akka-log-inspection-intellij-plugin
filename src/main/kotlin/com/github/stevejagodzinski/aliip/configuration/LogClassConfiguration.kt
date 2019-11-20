package com.github.stevejagodzinski.aliip.configuration

import com.github.stevejagodzinski.aliip.configuration.component.LogClassConfigurationComponent
import com.intellij.openapi.options.SearchableConfigurable
import com.intellij.openapi.project.Project
import com.intellij.util.text.nullize
import javax.swing.JComponent


class LogClassConfiguration(project: Project) : SearchableConfigurable {

    private val component = LogClassConfigurationComponent()
    private val settings = Settings.getInstance(project)

    override fun isModified(): Boolean {
        return component.getLogClass()?.nullize() != settings.state.logClass?.nullize()
    }

    override fun getId(): String {
        return "com.github.stevejagodzinski.allip.log-class"
    }

    override fun getDisplayName(): String {
        return "Akka Log Inspections"
    }

    override fun apply() {
        settings.setLogClass(component.getLogClass())
    }

    override fun createComponent(): JComponent? {
        return component
    }
}