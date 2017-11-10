package com.vik.groovy;

import java.util.Map;

import groovy.text.markup.BaseTemplate;
import groovy.text.markup.MarkupTemplateEngine;
import groovy.text.markup.TemplateConfiguration;

public abstract class XmlBaseTemplate extends BaseTemplate {

    public XmlBaseTemplate(final MarkupTemplateEngine templateEngine, final Map model, final Map<String, String> modelTypes,
            final TemplateConfiguration configuration) {
        super(templateEngine, model, modelTypes, configuration);
    }

    public void helloWorld() {
        System.out.println("Inside hello World method");
    }

}
