package com.github.stevejagodzinski.filters

import com.github.stevejagodzinski.predicates.IsString.isString
import com.intellij.psi.PsiExpression
import com.intellij.psi.PsiMethodCallExpression

object FindTemplate {
    fun findTemplate(expression: PsiMethodCallExpression) {
        findTemplateExpression(expression)
    }

    private fun findTemplateExpression(expression: PsiMethodCallExpression): PsiExpression? {
        for (methodArgument in expression.argumentList.expressions) {
            if (isString(methodArgument, expression) == true) {
                return methodArgument;
            }
        }
        return null;
    }

    private fun isString(methodArgument: PsiExpression, expression: PsiMethodCallExpression): Boolean? {
        return isString(methodArgument.type, expression)
    }
}