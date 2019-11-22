package com.github.stevejagodzinski.aliip.configuration

import com.github.stevejagodzinski.aliip.configuration.component.LogClassConfigurationComponent
import com.intellij.openapi.options.SearchableConfigurable
import com.intellij.openapi.project.Project
import com.intellij.util.text.nullize
import javax.swing.JComponent


class LogClassConfiguration(project: Project) : SearchableConfigurable {
    private val settings = LogClassSettings(project)
    private val component = LogClassConfigurationComponent(getOldLogClass())

    override fun isModified(): Boolean {
        return getNewLogClass() != getOldLogClass()
    }

    override fun getId(): String {
        return "com.github.stevejagodzinski.aliip.log-class"
    }

    override fun getDisplayName(): String {
        return "Akka Log Inspections"
    }

    override fun apply() {
        settings.setLogClass(getNewLogClass())
    }

    override fun createComponent(): JComponent? {
        return component
    }

    private fun getNewLogClass(): String? {
        return component.getLogClass()?.nullize()
    }

    private fun getOldLogClass(): String? {
        return settings.getLogClass()
    }
}