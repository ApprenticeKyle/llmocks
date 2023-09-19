package com.llmocks.entity;

import java.util.List;

public class Context {

    private String _package;

    private List<String> javaImports;

    private List<String> otherImports;

    private List<String> staticImports;

    private List<AnnotationContext> annotations;

    private String classname;

    private List<FieldContext> fieldContexts;


}
