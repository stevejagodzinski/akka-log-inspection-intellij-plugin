package com.github.stevejagodzinski.aliip.inspection

import com.github.stevejagodzinski.aliip.inspection.visitor.LogMethodVisitor
import com.github.stevejagodzinski.aliip.violation.ThrowableArgumentIndexViolation
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor

class ThrowableArgumentIndexInspection: LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return LogMethodVisitor(holder, ::ThrowableArgumentIndexViolation)
    }
}