package com.github.stevejagodzinski.inspection

import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.JavaElementVisitor
import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiMethodCallExpression
import com.intellij.psi.PsiType

class LogMethodVisitor(holder: ProblemsHolder) : JavaElementVisitor() {
    override fun visitMethodCallExpression(expression: PsiMethodCallExpression?) {
        super.visitMethodCallExpression(expression)

        if (isLogMethod(expression) == true) {

        }
    }

    private fun isLogMethod(expression: PsiMethodCallExpression?): Boolean? {
        return IsLogMethodPredicate.isLogMethod(expression);
    }
}