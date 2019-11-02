package com.github.stevejagodzinski.predicates

import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiExpression
import com.intellij.psi.PsiType

object IsString {
    fun isString(type: PsiType?, expression: PsiExpression): Boolean {
        val stringType = PsiClassType.getTypeByName("java.lang.String", expression.project, expression.resolveScope)
        return type?.isAssignableFrom(stringType) ?: false
    }

    fun isString(expression: PsiExpression): Boolean {
        return isString(expression.type, expression)
    }
}