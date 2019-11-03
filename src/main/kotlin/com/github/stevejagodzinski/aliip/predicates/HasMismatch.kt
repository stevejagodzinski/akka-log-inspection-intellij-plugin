package com.github.stevejagodzinski.aliip.predicates

import com.github.stevejagodzinski.aliip.counters.CountParameters.countParameters
import com.github.stevejagodzinski.aliip.counters.CountPlaceholders.countPlaceholders
import com.github.stevejagodzinski.aliip.filters.FindTemplate.findTemplate
import com.intellij.psi.PsiMethodCallExpression

object HasMismatch {
    fun hasMismatch(logExpression: PsiMethodCallExpression): Boolean {
        val templateValue = findTemplate(logExpression)

        return if (templateValue != null) {
            val placeholders = countPlaceholders(templateValue)
            val parameters = countParameters(logExpression)
            placeholders != parameters
        } else {
            false
        }
    }
}