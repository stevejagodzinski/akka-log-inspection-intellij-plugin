package com.github.stevejagodzinski.aliip.configuration

import com.intellij.openapi.options.SearchableConfigurable
import javax.swing.JComponent
import javax.swing.JPanel

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
        return JPanel()
    }
}