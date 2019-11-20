package com.github.stevejagodzinski.aliip.configuration.component

import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBList
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

        createListBox()
    }

    fun getLogClass(): String? {
        return textField.text.trim()
    }

    private fun createLabel() {
        val label = JBLabel("Additional Akka Log Class:")
        val labelGbc = GridBagConstraints()
        add(label, labelGbc)
    }

    private fun createTextField(logClass: String?): JTextField {
        val field = JBTextField()
        field.text = logClass
        val fieldGbc = GridBagConstraints()
        fieldGbc.fill = HORIZONTAL
        fieldGbc.weightx = 1.0
        add(field, fieldGbc)
        return field
    }

    private fun createListBox() {
        val list = JBList<String>()
        val listGbc = GridBagConstraints()
        listGbc.gridwidth = 2
        listGbc.fill = BOTH
        listGbc.gridx = 0
        listGbc.gridy = 1
        listGbc.weightx = 1.0
        listGbc.weighty = 1.0
        add(list, listGbc)
    }
}
