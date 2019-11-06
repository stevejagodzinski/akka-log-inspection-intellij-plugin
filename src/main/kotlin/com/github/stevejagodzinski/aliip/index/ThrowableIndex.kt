package com.github.stevejagodzinski.aliip.index

import com.github.stevejagodzinski.aliip.predicates.IsThrowable.isThrowable
import com.intellij.psi.PsiMethodCallExpression

object ThrowableIndex {
    fun throwableIndex(expression: PsiMethodCallExpression): Int {
        return expression.argumentList.expressions.indexOfFirst { x -> isThrowable(x) }
    }
}