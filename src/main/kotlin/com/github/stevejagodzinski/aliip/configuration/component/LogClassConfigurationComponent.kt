package com.github.stevejagodzinski.aliip.configuration.component

import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import java.awt.GridBagConstraints
import java.awt.GridBagConstraints.BOTH
import java.awt.GridBagConstraints.HORIZONTAL
import java.awt.GridBagLayout
import javax.swing.JPanel
import javax.swing.JTextField

class LogClassConfigurationComponent(logClass: String? = null): JPanel(GridBagLayout()) {

    val textField: JTextField

    init {
        createLabel()
        this.textField = createTextField(logClass)

        createFiller()
    }

    fun getLogClass(): String? {
        return textField.text.trim()
    }

    private fun createLabel() {
        val component = JBLabel("Additional Akka Log Class:")
        add(component, GridBagConstraints())
    }

    private fun createTextField(logClass: String?): JTextField {
        val component = JBTextField()
        component.text = logClass

        val constraints = GridBagConstraints()
        constraints.fill = HORIZONTAL
        constraints.weightx = 1.0

        add(component, constraints)
        return component
    }

    private fun createFiller() {
        val component = JBLabel()

        val constraints = GridBagConstraints()
        constraints.gridwidth = 2
        constraints.fill = BOTH
        constraints.gridx = 0
        constraints.gridy = 1
        constraints.weightx = 1.0
        constraints.weighty = 1.0

        add(component, constraints)
    }
}
