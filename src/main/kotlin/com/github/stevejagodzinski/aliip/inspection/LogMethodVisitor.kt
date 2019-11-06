package com.github.stevejagodzinski.aliip.inspection

import com.github.stevejagodzinski.aliip.predicates.HasMismatch.hasMismatch
import com.github.stevejagodzinski.aliip.predicates.IsLogMethod.isLogMethod
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.JavaElementVisitor
import com.intellij.psi.PsiMethodCallExpression

class LogMethodVisitor(private val holder: ProblemsHolder) : JavaElementVisitor() {
    override fun visitMethodCallExpression(expression: PsiMethodCallExpression?) {
        super.visitMethodCallExpression(expression)

        if (isLogMethod(expression) && hasMismatch(expression!!)) {
            violate(expression)
        }
    }

    private fun violate(expression: PsiMethodCallExpression) {
        holder.registerProblem(expression, LogPlaceholderInspection.DESCRIPTION_TEMPLATE)
    }
}