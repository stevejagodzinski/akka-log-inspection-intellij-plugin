package com.github.stevejagodzinski.aliip.predicates

import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiExpression
import com.intellij.psi.PsiType

object IsThrowable {
    fun isThrowable(type: PsiType?, expression: PsiExpression): Boolean {
        val throwableType = PsiClassType.getTypeByName("java.lang.Throwable", expression.project, expression.resolveScope)
        return type?.let { throwableType.isAssignableFrom(it) } ?: false
    }

    fun isThrowable(expression: PsiExpression): Boolean {
        return isThrowable(expression.type, expression)
    }
}