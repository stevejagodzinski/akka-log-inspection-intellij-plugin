package com.github.stevejagodzinski.inspection

import com.github.stevejagodzinski.predicates.IsLogMethodPredicate.isLogMethod
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.JavaElementVisitor
import com.intellij.psi.PsiMethodCallExpression


class LogMethodVisitor(private val holder: ProblemsHolder) : JavaElementVisitor() {
    override fun visitMethodCallExpression(expression: PsiMethodCallExpression?) {
        super.visitMethodCallExpression(expression)

        if (isLogMethod(expression) == true) {
            alwaysViolate(expression)
        }
    }

    private fun alwaysViolate(expression: PsiMethodCallExpression?) {
        if (expression != null) {
            holder.registerProblem(expression, LogPlaceholderInspection.DESCRIPTION_TEMPLATE)
        }
    }
}