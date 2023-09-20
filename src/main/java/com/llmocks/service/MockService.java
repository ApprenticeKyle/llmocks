package com.llmocks.service;

import com.intellij.psi.PsiClass;
import com.llmocks.cache.MockCache;

public class MockService {

    public static void mock() {
        PsiClass clz = MockCache.CLASS.get();

        ClassService.parseClass(clz);

    }
}
