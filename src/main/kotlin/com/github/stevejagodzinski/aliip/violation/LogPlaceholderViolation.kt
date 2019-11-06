package com.github.stevejagodzinski.aliip.violation

import com.github.stevejagodzinski.aliip.counters.CountParameters
import com.github.stevejagodzinski.aliip.counters.CountPlaceholders
import com.github.stevejagodzinski.aliip.filters.FindTemplate
import com.intellij.psi.PsiMethodCallExpression

class LogPlaceholderViolation(logExpression: PsiMethodCallExpression) : Violation(logExpression) {
    private val templateValue = FindTemplate.findTemplate(logExpression)

    val placeholders = if (templateValue != null) {
        CountPlaceholders.countPlaceholders(templateValue)
    } else {
        0
    }

    val parameters = CountParameters.countParameters(logExpression)

    override fun hasViolation(): Boolean {
        return placeholders != parameters
    }

    override fun description(): String {
        val prefix =  prefix()
        return "$prefix arguments provided ($parameters) than placeholders specified ($placeholders)"
    }

    private fun prefix(): String {
        return when {
            parameters < placeholders -> "Fewer"
            parameters > placeholders -> "More"
            else -> throw UnsupportedOperationException("Trying to get description when hasViolation should be false. placeholders=$placeholders parameters=$parameters")
        }
    }
}