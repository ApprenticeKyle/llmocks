package com.llmocks.entity;

import java.util.List;

public class FieldContext implements Context{

    private String type;

    private String name;

    private List<AnnotationContext> annotations;

    @Override
    public String getBody() {
        return null;
    }
}
