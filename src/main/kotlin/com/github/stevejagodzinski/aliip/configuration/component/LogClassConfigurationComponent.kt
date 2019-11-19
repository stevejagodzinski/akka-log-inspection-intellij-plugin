package com.github.stevejagodzinski.aliip.configuration.component

import java.awt.GridBagConstraints
import java.awt.GridBagConstraints.HORIZONTAL
import java.awt.GridBagLayout
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField

class LogClassConfigurationComponent() : JPanel(GridBagLayout()) {
    init {
        val label = JLabel("Additional Akka Log Class:")
        val labelGbc = GridBagConstraints()
        add(label, labelGbc)

        val field = JTextField()
        val fieldGbc = GridBagConstraints()
        fieldGbc.fill = HORIZONTAL
        add(field, fieldGbc)
    }
}