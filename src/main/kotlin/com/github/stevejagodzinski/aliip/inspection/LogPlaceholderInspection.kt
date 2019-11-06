package com.github.stevejagodzinski.aliip.inspection

import com.github.stevejagodzinski.aliip.violation.LogPlaceholderViolation
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor

class LogPlaceholderInspection : LocalInspectionTool() {
    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return LogMethodVisitor(holder, ::LogPlaceholderViolation)
    }
}