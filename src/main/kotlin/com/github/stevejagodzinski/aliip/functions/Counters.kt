package com.github.stevejagodzinski.aliip.functions

import com.intellij.psi.PsiMethodCallExpression

fun countParameters(logExpression: PsiMethodCallExpression): Int {
    val templateIndex = templateIndex(logExpression)
    val numberOfMethodParameters = logExpression.argumentList.expressionCount
    return numberOfMethodParameters - templateIndex - 1
}

fun countPlaceholders(template: String): Int {
    return template.split("{}").size - 1
}
