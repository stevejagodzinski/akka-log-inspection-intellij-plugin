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
        for (methodArgument in expression.argumentList.expressions) {
            if (isString(methodArgument, expression) == true) {
                return methodArgument
            }
        }
        return null
    }

    private fun isString(methodArgument: PsiExpression, expression: PsiMethodCallExpression): Boolean? {
        return isString(methodArgument.type, expression)
    }
}