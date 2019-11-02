package com.github.stevejagodzinski.predicates

import com.github.stevejagodzinski.counters.CountParameters.countParameters
import com.github.stevejagodzinski.counters.CountPlaceholders.countPlaceholders
import com.github.stevejagodzinski.filters.FindTemplate.findTemplate
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