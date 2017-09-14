package com.vik.groovy.test;

import java.io.IOException;

import org.codehaus.groovy.control.CompilationFailedException;
import org.junit.Test;

import com.vik.groovy.CreateXmlGrooyTemplate;

public class TestTemplateBuilder {

    @Test
    public void testTemplateBuilder() throws CompilationFailedException, ClassNotFoundException, IOException {
        CreateXmlGrooyTemplate templateBuilder = new CreateXmlGrooyTemplate();
        templateBuilder.groovyTemplatePrint();
    }

}
