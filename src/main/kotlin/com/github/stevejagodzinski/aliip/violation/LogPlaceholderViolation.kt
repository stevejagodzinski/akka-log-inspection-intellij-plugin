package com.github.stevejagodzinski.aliip.violation

import com.github.stevejagodzinski.aliip.functions.countParameters
import com.github.stevejagodzinski.aliip.functions.countPlaceholders
import com.github.stevejagodzinski.aliip.functions.findTemplate
import com.intellij.psi.PsiMethodCallExpression

class LogPlaceholderViolation(logExpression: PsiMethodCallExpression) : Violation(logExpression) {
    private val templateValue = logExpression.findTemplate()

    val placeholders = templateValue?.countPlaceholders() ?: 0

    val parameters = logExpression.countParameters()

    override fun hasViolation(): Boolean {
        return placeholders != parameters
    }

    override fun description(): String {
        return "${prefix()} arguments provided ($parameters) than placeholders specified ($placeholders)"
    }

    private fun prefix(): String {
        return when {
            parameters < placeholders -> "Fewer"
            parameters > placeholders -> "More"
            else -> throw UnsupportedOperationException("Trying to get description when hasViolation should be false. placeholders=$placeholders parameters=$parameters")
        }
    }
}