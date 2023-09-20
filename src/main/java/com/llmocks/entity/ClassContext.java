package com.llmocks.entity;

import java.util.List;

public class ClassContext implements Context {

    private String _package;

    private List<String> javaImports;

    private List<String> otherImports;

    private List<String> staticImports;

    private List<AnnotationContext> annotations;

    private String classname;

    private List<FieldContext> fieldContexts;


    @Override
    public String getBody() {
        return null;
    }
}
