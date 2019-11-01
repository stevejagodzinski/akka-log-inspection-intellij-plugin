package com.github.stevejagodzinski.inspection

import com.github.stevejagodzinski.inspection.IsLogMethodPredicate.isLogMethod
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.JavaElementVisitor
import com.intellij.psi.PsiMethodCallExpression


class LogMethodVisitor(private val holder: ProblemsHolder) : JavaElementVisitor() {
    override fun visitMethodCallExpression(expression: PsiMethodCallExpression?) {
        super.visitMethodCallExpression(expression)

        if (isLogMethod(expression) == true) {
            checkMethodArguments(expression)
        }
    }

    private fun checkMethodArguments(expression: PsiMethodCallExpression?) {

    }
}