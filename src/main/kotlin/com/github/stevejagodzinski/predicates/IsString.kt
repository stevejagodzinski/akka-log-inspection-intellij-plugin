package com.github.stevejagodzinski.predicates

import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiMethodCallExpression
import com.intellij.psi.PsiType

object IsString {
    fun isString(type: PsiType?, expression: PsiMethodCallExpression): Boolean? {
        val stringType = PsiClassType.getTypeByName("java.lang.String", expression.project, expression.resolveScope)
        return type?.isAssignableFrom(stringType)
    }
}