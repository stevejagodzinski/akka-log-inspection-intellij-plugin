package com.github.stevejagodzinski.aliip.inspection.visitor

import com.github.stevejagodzinski.aliip.violation.Violation
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiMethodCallExpression

class ErrorLogMethodVisitor(holder: ProblemsHolder, createViolation: (expression: PsiMethodCallExpression) -> Violation) : LogMethodVisitor(holder, createViolation) {
    override fun shouldVisit(expression: PsiMethodCallExpression?): Boolean {
        return super.shouldVisit(expression) && this.isError(expression!!)
    }

    private fun isError(expression: PsiMethodCallExpression): Boolean {
        return expression.resolveMethod()?.name == "error"
    }
}
