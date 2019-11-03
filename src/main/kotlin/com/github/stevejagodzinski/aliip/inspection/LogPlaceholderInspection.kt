package com.github.stevejagodzinski.aliip.inspection

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElementVisitor

class LogPlaceholderInspection : LocalInspectionTool() {
    companion object LogPlaceholderInspection {
        const val DESCRIPTION_TEMPLATE: String = "Number of log parameters does not match the number of template placeholders :("
    }

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return LogMethodVisitor(holder)
    }
}