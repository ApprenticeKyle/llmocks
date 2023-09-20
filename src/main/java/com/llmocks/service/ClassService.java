package com.llmocks.service;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElementFactory;
import com.intellij.psi.PsiJavaFile;
import com.llmocks.cache.MockCache;

public class ClassService {

    public static void parseClass(PsiClass clz) {
        Project project = MockCache.PROJECT.get();
        PsiJavaFile file = MockCache.TEST_FILE.get();
        String className = MockCache.ClASS_NAME.get();
        PsiElementFactory factory = PsiElementFactory.getInstance(project);
        PsiClass testClass = factory.createClass(className);
//        testClass.add(factory.createAnnotationType("@RunWith(MockitoJUnitRunner.class)"));
        WriteCommandAction.runWriteCommandAction(project, () -> {
            testClass.add(factory.createImportStatementOnDemand("org.mockito.junit.MockitoJUnitRunner"));
            testClass.add(factory.createImportStatementOnDemand("org.junit.Test"));
            testClass.add(factory.createImportStatementOnDemand("org.mockito.Mock"));
            testClass.add(factory.createImportStatementOnDemand("org.mockito.InjectMocks"));
            testClass.add(factory.createImportStatementOnDemand("org.mockito.Mockito"));
            testClass.add(factory.createImportStatementOnDemand("org.mockito.Spy"));
            file.add(testClass);
        });


//        PsiField[] fields = clz.getFields();
//        for (PsiField field : fields) {
//            FieldService.parse(field);
//        }
//        PsiMethod[] methods = clz.getMethods();
//        for (PsiMethod method : methods) {
//            MethodService.parse(method);
//        }
    }
}
