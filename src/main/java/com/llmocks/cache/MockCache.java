package com.llmocks.cache;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiJavaFile;

public class MockCache {

    public static final ThreadLocal<PsiJavaFile> TEST_FILE = new ThreadLocal<>();
    public static final ThreadLocal<PsiClass> CLASS = new ThreadLocal<>();

    public static final ThreadLocal<Project> PROJECT = new ThreadLocal<>();

    public static final ThreadLocal<String> ClASS_NAME = new ThreadLocal<>();

    public static void initCache(PsiJavaFile testFile, PsiClass clz) {
        TEST_FILE.set(testFile);
        CLASS.set(clz);
        PROJECT.set(testFile.getProject());
    }
}
