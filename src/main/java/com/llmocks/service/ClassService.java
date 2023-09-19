package com.llmocks.service;

import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiMethod;

public class ClassService {

    public static void parseClass(PsiClass clz) {
        String className = clz.getName();
        PsiMethod[] methods = clz.getMethods();
        for (PsiMethod method : methods) {
            MethodService.parseMethod(method);
        }
    }
}
