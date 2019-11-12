package com.github.stevejagodzinski.aliip.functions

import com.intellij.psi.PsiMethodCallExpression

fun PsiMethodCallExpression.countParameters(): Int {
    val templateIndex = templateIndex()
    val numberOfMethodParameters = argumentList.expressionCount
    return numberOfMethodParameters - templateIndex - 1
}

fun String.countPlaceholders(): Int {
    return split("{}").size - 1
}
