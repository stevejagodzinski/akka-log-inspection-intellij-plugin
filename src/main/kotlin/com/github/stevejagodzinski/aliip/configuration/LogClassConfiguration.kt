package com.github.stevejagodzinski.aliip.configuration

import com.github.stevejagodzinski.aliip.configuration.component.LogClassConfigurationComponent
import com.intellij.openapi.options.SearchableConfigurable
import javax.swing.JComponent


class LogClassConfiguration : SearchableConfigurable {
    override fun isModified(): Boolean {
        return false
    }

    override fun getId(): String {
        return "com.github.stevejagodzinski.allip.log-class"
    }

    override fun getDisplayName(): String {
        return "Akka Log Inspections"
    }

    override fun apply() {
        // NO OP
    }

    override fun createComponent(): JComponent? {
        return LogClassConfigurationComponent()
    }
}