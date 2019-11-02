package com.github.stevejagodzinski.filters

import com.github.stevejagodzinski.predicates.IsString.isString
import com.intellij.psi.PsiExpression
import com.intellij.psi.PsiLiteralValue
import com.intellij.psi.PsiMethodCallExpression

object FindTemplate {
    fun findTemplate(expression: PsiMethodCallExpression): String? {
        val templatePsiExpression = findTemplateExpression(expression)

        if (templatePsiExpression is PsiLiteralValue) {
            val value = templatePsiExpression.value
            if (value is String) {
                return value
            }
        }

        return null
    }

    private fun findTemplateExpression(expression: PsiMethodCallExpression): PsiExpression? {
        return expression.argumentList.expressions.firstOrNull { x -> isString(x) }
    }
}