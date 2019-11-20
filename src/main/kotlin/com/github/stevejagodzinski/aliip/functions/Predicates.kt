package com.github.stevejagodzinski.aliip.functions

import com.github.stevejagodzinski.aliip.configuration.LogClassSettings
import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiExpression
import com.intellij.psi.PsiMethodCallExpression
import com.intellij.psi.PsiType
import com.intellij.util.text.nullize

fun PsiMethodCallExpression.isLogMethod(): Boolean {
    return getLogMethodTypes().find { logType ->
        val loggingAdapterType = PsiClassType.getTypeByName(logType, project, resolveScope)
        return getReturnType()?.let { loggingAdapterType.isAssignableFrom(it) } ?: false
    } != null
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

private fun PsiMethodCallExpression.getLogMethodTypes(): Set<String> {
    val logClass = LogClassSettings(project).getLogClass().nullize()

    return if (logClass != null) {
        setOf("akka.event.LoggingAdapter", logClass)
    } else {
        setOf("akka.event.LoggingAdapter")
    }
}

private fun PsiMethodCallExpression.getReturnType(): PsiType? {
    return methodExpression.qualifierExpression?.type
}
