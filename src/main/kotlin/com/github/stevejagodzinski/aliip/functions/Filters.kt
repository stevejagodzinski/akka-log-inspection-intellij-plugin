package com.github.stevejagodzinski.aliip.functions

import com.intellij.psi.PsiExpression
import com.intellij.psi.PsiLiteralValue
import com.intellij.psi.PsiMethodCallExpression

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
