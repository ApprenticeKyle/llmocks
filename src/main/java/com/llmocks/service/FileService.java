package com.llmocks.service;

import com.intellij.ide.highlighter.JavaFileType;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiDirectory;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.impl.file.PsiDirectoryFactory;
import com.intellij.psi.impl.source.PsiJavaFileImpl;
import com.llmocks.cache.MockCache;
import com.llmocks.constant.Const;

import java.io.IOException;

public class FileService {

    public static PsiDirectory getTestAbsolutelyPath(Project project, PsiClass clz) {
        PsiDirectoryFactory instance = PsiDirectoryFactory.getInstance(project);
        PsiJavaFileImpl parent = (PsiJavaFileImpl) clz.getParent();
        String packageName = parent.getPackageName();
        PsiDirectory directory = null;
        try {
            String testFile = project.getBasePath() + "/src/test/java/" + packageName.replace(".", "/");
            VirtualFile testRootPath = VfsUtil.createDirectoryIfMissing(testFile);
            assert testRootPath != null;
            directory = instance.createDirectory(testRootPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return directory;
    }

    public static PsiJavaFile prepareTestFile(Project project, PsiClass clz) {
        PsiDirectory directory = FileService.getTestAbsolutelyPath(project, clz);
        PsiFileFactory instance = PsiFileFactory.getInstance(project);
        String className = clz.getName();
        String testClassName = className + Const.TEST_FILE_SUFFIX;
        MockCache.ClASS_NAME.set(testClassName);
        PsiJavaFile testFile = (PsiJavaFile) instance.createFileFromText(testClassName + Const.JAVA_FILE_SUFFIX, JavaFileType.INSTANCE, "");
        WriteCommandAction.runWriteCommandAction(project, () -> {
            directory.add(testFile);
        });
        return testFile;
    }
}
