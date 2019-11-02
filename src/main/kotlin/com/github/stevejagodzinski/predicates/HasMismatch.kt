package com.github.stevejagodzinski.predicates

import com.github.stevejagodzinski.counters.CountPlaceholders
import com.github.stevejagodzinski.filters.FindTemplate.findTemplate
import com.intellij.psi.PsiMethodCallExpression

object HasMismatch {
    fun hasMismatch(logExpression: PsiMethodCallExpression): Boolean {
        val templateValue = findTemplate(logExpression)
        if (templateValue != null) {
            val placeholders = CountPlaceholders.countPlaceholders(templateValue)
        } else {
            return false
        }
    }
}