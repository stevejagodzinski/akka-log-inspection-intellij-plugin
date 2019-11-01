package com.github.stevejagodzinski.predicates

import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiMethodCallExpression
import com.intellij.psi.PsiType

object IsLogMethodPredicate {
    fun isLogMethod(expression: PsiMethodCallExpression?): Boolean? {
        val returnType = getReturnType(expression)
        val loggingAdapterType = PsiClassType.getTypeByName("akka.event.LoggingAdapter", expression!!.project, expression.resolveScope)
        return returnType?.isAssignableFrom(loggingAdapterType)
    }

    private fun getReturnType(expression: PsiMethodCallExpression?): PsiType? {
        return expression?.methodExpression?.qualifierExpression?.type
    }
}