package com.github.stevejagodzinski.aliip.functions

import com.intellij.psi.PsiMethodCallExpression

fun PsiMethodCallExpression.templateIndex(): Int {
    return argumentList.expressions.indexOfFirst { x -> x.isString() }
}

fun PsiMethodCallExpression.throwableIndex(): Int {
    return argumentList.expressions.indexOfFirst { x -> x.isThrowable() }
}
