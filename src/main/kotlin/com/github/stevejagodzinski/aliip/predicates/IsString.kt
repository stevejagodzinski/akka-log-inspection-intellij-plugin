package com.github.stevejagodzinski.aliip.predicates

import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiExpression
import com.intellij.psi.PsiType

object IsString {
    fun isString(type: PsiType?, expression: PsiExpression): Boolean {
        val stringType = PsiClassType.getTypeByName("java.lang.String", expression.project, expression.resolveScope)
        return type?.let { stringType.isAssignableFrom(it) } ?: false
    }

    fun isString(expression: PsiExpression): Boolean {
        return isString(expression.type, expression)
    }
}