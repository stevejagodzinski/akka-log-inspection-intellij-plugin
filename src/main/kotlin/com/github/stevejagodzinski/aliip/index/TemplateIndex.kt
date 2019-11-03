package com.github.stevejagodzinski.aliip.index

import com.github.stevejagodzinski.aliip.predicates.IsString.isString
import com.intellij.psi.PsiMethodCallExpression

object TemplateIndex {
    fun templateIndex(expression: PsiMethodCallExpression): Int {
        return expression.argumentList.expressions.indexOfFirst { x -> isString(x) }
    }
}