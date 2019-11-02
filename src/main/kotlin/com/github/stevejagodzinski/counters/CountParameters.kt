package com.github.stevejagodzinski.counters

import com.github.stevejagodzinski.index.TemplateIndex.templateIndex
import com.intellij.psi.PsiMethodCallExpression

object CountParameters {
    fun countParameters(logExpression: PsiMethodCallExpression): Int {
        val templateIndex = templateIndex(logExpression)
        val numberOfMethodParameters = logExpression.argumentList.expressionCount
        return numberOfMethodParameters - templateIndex - 1
    }
}