package com.llmocks;

import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiJavaFile;
import com.llmocks.cache.MockCache;
import com.llmocks.service.FileService;
import com.llmocks.service.MockService;
import org.jetbrains.annotations.NotNull;

public class MockAction extends AnAction {

    @Override
    public @NotNull ActionUpdateThread getActionUpdateThread() {
        return ActionUpdateThread.BGT;
    }

    @Override
    public void actionPerformed(AnActionEvent anActionEvent) {
        PsiFile psiFile = anActionEvent.getData(CommonDataKeys.PSI_FILE);
        Project project = anActionEvent.getProject();
        if (project == null || !(psiFile instanceof PsiJavaFile javaFile)) {
            return;
        }
        for (PsiClass clz : javaFile.getClasses()) {
            //generate test file
            PsiJavaFile testFile = FileService.prepareTestFile(project, clz);
            //init cache
            MockCache.initCache(testFile, clz);
            //start mock
            MockService.mock();
        }
        Messages.showMessageDialog(project, "Success", "Mock Result", Messages.getInformationIcon());
    }

    @Override
    public void update(AnActionEvent e) {
        Editor editor = e.getData(CommonDataKeys.EDITOR);
        PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);
        e.getPresentation().setEnabled(editor != null && psiFile != null);
    }
}
