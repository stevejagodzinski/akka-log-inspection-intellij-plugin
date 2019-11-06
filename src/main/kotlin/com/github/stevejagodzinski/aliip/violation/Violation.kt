package com.github.stevejagodzinski.aliip.violation

import com.intellij.psi.PsiMethodCallExpression

abstract class Violation(val logExpression: PsiMethodCallExpression) {
    abstract fun hasViolation(): Boolean
    abstract fun description(): String
}