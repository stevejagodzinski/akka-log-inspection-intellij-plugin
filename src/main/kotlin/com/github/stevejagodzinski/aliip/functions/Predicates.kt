package com.github.stevejagodzinski.aliip.functions

import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiExpression
import com.intellij.psi.PsiMethodCallExpression
import com.intellij.psi.PsiType

fun isLogMethod(expression: PsiMethodCallExpression?): Boolean {
    val returnType = getReturnType(expression)
    val loggingAdapterType = PsiClassType.getTypeByName("akka.event.LoggingAdapter", expression!!.project, expression.resolveScope)
    return returnType?.let { loggingAdapterType.isAssignableFrom(it) } ?: false
}

fun isString(type: PsiType?, expression: PsiExpression): Boolean {
    val stringType = PsiClassType.getTypeByName("java.lang.String", expression.project, expression.resolveScope)
    return type?.let { stringType.isAssignableFrom(it) } ?: false
}

fun isString(expression: PsiExpression): Boolean {
    return isString(expression.type, expression)
}

fun isThrowable(type: PsiType?, expression: PsiExpression): Boolean {
    val throwableType = PsiClassType.getTypeByName("java.lang.Throwable", expression.project, expression.resolveScope)
    return type?.let { throwableType.isAssignableFrom(it) } ?: false
}

fun isThrowable(expression: PsiExpression): Boolean {
    return isThrowable(expression.type, expression)
}

private fun getReturnType(expression: PsiMethodCallExpression?): PsiType? {
    return expression?.methodExpression?.qualifierExpression?.type
}