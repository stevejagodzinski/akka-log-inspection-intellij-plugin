package com.github.stevejagodzinski.aliip.functions

import com.github.stevejagodzinski.aliip.configuration.LogClassSettings
import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiExpression
import com.intellij.psi.PsiMethodCallExpression
import com.intellij.psi.PsiType
import com.intellij.util.text.nullize

const val ERROR = "error"
const val WARN = "warning"
const val INFO = "info"
const val DEBUG = "debug"
val LOG_METHOD_NAMES = arrayOf(ERROR, WARN, INFO, DEBUG)

fun PsiMethodCallExpression.isLogMethod(): Boolean {
    return hasLogMethodType() && hasLogMethodName()
}

fun PsiMethodCallExpression.hasLogMethodType(): Boolean {
    return getLogMethodTypes().find { logClass -> isAssignableFrom(logClass) } != null
}

fun PsiMethodCallExpression.isAssignableFrom(className: String): Boolean {
    val returnType = getReturnType()
    val loggingAdapterType = PsiClassType.getTypeByName(className, project, resolveScope)
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

fun PsiMethodCallExpression.hasLogMethodName(): Boolean {
    return LOG_METHOD_NAMES.contains(resolveMethod()?.name)
}

private fun PsiMethodCallExpression.getLogMethodTypes(): Set<String> {
    val logClass = LogClassSettings(project).getLogClass().nullize()

    return if (logClass != null) {
        setOf(logClass, "akka.event.LoggingAdapter")
    } else {
        setOf("akka.event.LoggingAdapter")
    }
}

private fun PsiMethodCallExpression.getReturnType(): PsiType? {
    return methodExpression.qualifierExpression?.type
}
