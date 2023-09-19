package com.llmocks.service;

import com.intellij.psi.PsiCodeBlock;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiStatement;

public class MethodService {

    public static void parseMethod(PsiMethod method) {
        PsiCodeBlock body = method.getBody();
        if (body == null) {
            return;
        }
        for (PsiStatement statement : body.getStatements()) {
            StatementService.parseStatement(statement);
        }
    }
}
