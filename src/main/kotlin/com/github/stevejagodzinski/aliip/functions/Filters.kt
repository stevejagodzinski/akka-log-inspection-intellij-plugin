package com.github.stevejagodzinski.aliip.functions

import com.intellij.psi.PsiExpression
import com.intellij.psi.PsiLiteralValue
import com.intellij.psi.PsiMethodCallExpression

fun PsiMethodCallExpression.findTemplate(): String? {
    val templatePsiExpression = findTemplateExpression()

    if (templatePsiExpression is PsiLiteralValue) {
        val value = templatePsiExpression.value
        if (value is String) {
            return value
        }
    }

    return null
}

private fun PsiMethodCallExpression.findTemplateExpression(): PsiExpression? {
    return argumentList.expressions.firstOrNull { x -> x.isString() }
}
