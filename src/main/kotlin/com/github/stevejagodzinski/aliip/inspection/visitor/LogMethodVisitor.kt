package com.github.stevejagodzinski.aliip.inspection.visitor

import com.github.stevejagodzinski.aliip.predicates.IsLogMethod.isLogMethod
import com.github.stevejagodzinski.aliip.violation.Violation
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.JavaElementVisitor
import com.intellij.psi.PsiMethodCallExpression

open class LogMethodVisitor(
        private val holder: ProblemsHolder,
        private val createViolation: (expression: PsiMethodCallExpression) -> Violation
) : JavaElementVisitor() {

    override fun visitMethodCallExpression(expression: PsiMethodCallExpression?) {
        super.visitMethodCallExpression(expression)

        if (shouldVisit(expression)) {
            val violationType = createViolation.invoke(expression!!)
            if (violationType.hasViolation()) {
                violate(violationType.logExpression, violationType.description())
            }
        }
    }

    open fun shouldVisit(expression: PsiMethodCallExpression?): Boolean {
        return isLogMethod(expression)
    }

    private fun violate(expression: PsiMethodCallExpression, description: String) {
        holder.registerProblem(expression, description)
    }
}
