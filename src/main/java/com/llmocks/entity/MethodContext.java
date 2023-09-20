package com.llmocks.entity;

import java.util.List;

public class MethodContext implements Context{

    private List<AnnotationContext> annotations;

    private String name;

    private String body;

    private List<String> exceptions;


    @Override
    public String getBody() {
        return null;
    }
}
