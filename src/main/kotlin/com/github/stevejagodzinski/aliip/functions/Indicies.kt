package com.github.stevejagodzinski.aliip.functions

import com.intellij.psi.PsiMethodCallExpression

fun templateIndex(expression: PsiMethodCallExpression): Int {
    return expression.argumentList.expressions.indexOfFirst { x -> isString(x) }
}

fun throwableIndex(expression: PsiMethodCallExpression): Int {
    return expression.argumentList.expressions.indexOfFirst { x -> isThrowable(x) }
}
