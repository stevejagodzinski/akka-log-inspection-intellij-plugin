package com.github.stevejagodzinski.aliip.violation

import com.github.stevejagodzinski.aliip.functions.throwableIndex
import com.intellij.psi.PsiMethodCallExpression

class ThrowableArgumentIndexViolation(logExpression: PsiMethodCallExpression) : Violation(logExpression) {
    val throwableIndex = logExpression.throwableIndex()

    override fun description(): String {
        return "Throwable at argument ($throwableIndex) should be the first argument to log().error(Throwable, String, Object...)"
    }

    override fun hasViolation(): Boolean {
        return throwableIndex > 0
    }
}
