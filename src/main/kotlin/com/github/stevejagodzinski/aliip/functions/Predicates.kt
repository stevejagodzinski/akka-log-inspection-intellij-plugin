package com.github.stevejagodzinski.aliip.functions

import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiExpression
import com.intellij.psi.PsiMethodCallExpression
import com.intellij.psi.PsiType

fun PsiMethodCallExpression.isLogMethod(): Boolean {
    val returnType = getReturnType()
    val loggingAdapterType = PsiClassType.getTypeByName("akka.event.LoggingAdapter", project, resolveScope)
    return returnType?.let { loggingAdapterType.isAssignableFrom(it) } ?: false
}

fun PsiExpression.isString(type: PsiType?): Boolean {
    val stringType = PsiClassType.getTypeByName("java.lang.String", project, resolveScope)
    return type?.let { stringType.isAssignableFrom(it) } ?: false
}

fun PsiExpression.isString(): Boolean {
    return isString(type)
}

fun PsiExpression.isThrowable(type: PsiType?): Boolean {
    val throwableType = PsiClassType.getTypeByName("java.lang.Throwable", project, resolveScope)
    return type?.let { throwableType.isAssignableFrom(it) } ?: false
}

fun PsiExpression.isThrowable(): Boolean {
    return isThrowable(type)
}

private fun PsiMethodCallExpression.getReturnType(): PsiType? {
    return methodExpression.qualifierExpression?.type
}
