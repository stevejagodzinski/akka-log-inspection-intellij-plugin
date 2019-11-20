package com.github.stevejagodzinski.aliip.configuration.component

import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBList
import com.intellij.ui.components.JBTextField
import java.awt.GridBagConstraints
import java.awt.GridBagConstraints.BOTH
import java.awt.GridBagConstraints.HORIZONTAL
import java.awt.GridBagLayout
import javax.swing.JPanel

class LogClassConfigurationComponent: JPanel(GridBagLayout()) {
    init {
        createLabel()
        createTextField()

        createListBox()
    }

    private fun createLabel() {
        val label = JBLabel("Additional Akka Log Class:")
        val labelGbc = GridBagConstraints()
        add(label, labelGbc)
    }

    private fun createTextField() {
        val field = JBTextField()
        val fieldGbc = GridBagConstraints()
        fieldGbc.fill = HORIZONTAL
        fieldGbc.weightx = 1.0
        add(field, fieldGbc)
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
