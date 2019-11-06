package com.github.stevejagodzinski.aliip.violation

import com.github.stevejagodzinski.aliip.index.ThrowableIndex
import com.intellij.psi.PsiMethodCallExpression

class ThrowableArgumentIndexViolation(logExpression: PsiMethodCallExpression) : Violation(logExpression) {
    val throwableIndex = ThrowableIndex.throwableIndex(logExpression)

    override fun description(): String {
        return "Throwable at argument ($throwableIndex) should be the first argument to log().error(Throwable, String, Object...)"
    }

    override fun hasViolation(): Boolean {
        return throwableIndex > 0
    }
}
