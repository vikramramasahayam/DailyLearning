package com.vik.groovy;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.codehaus.groovy.control.CompilationFailedException;

import groovy.lang.Writable;
import groovy.text.Template;
import groovy.text.markup.MarkupTemplateEngine;
import groovy.text.markup.TemplateConfiguration;

public class CreateXmlGrooyTemplate {

    public void groovyTemplatePrint() throws CompilationFailedException, ClassNotFoundException, IOException {
        TemplateConfiguration templateConfig = new TemplateConfiguration();
        templateConfig.setAutoEscape(true);
        templateConfig.setAutoIndent(false);
        templateConfig.setAutoNewLine(false);
        templateConfig.setUseDoubleQuotes(true);
        templateConfig.setDeclarationEncoding(Charset.defaultCharset().name());
        templateConfig.setBaseTemplateClass(XmlBaseTemplate.class);
        StringWriter writer = new StringWriter();
        MarkupTemplateEngine engine = new MarkupTemplateEngine(templateConfig);
        File templateFile = FileUtils.toFile(CreateXmlGrooyTemplate.class.getResource("/grooy-template/books.tpl"));
        System.out.println(templateFile.getAbsolutePath());
        Template template = engine.createTemplate(templateFile);
        Map<String, Object> paramMap = new HashMap<>();

        Map<String, String> book1 = new HashMap<>();
        book1.put("author", "Gambardella, Matthew");
        book1.put("title", "XML Developer's Guide");

        Map<String, String> book2 = new HashMap<>();
        book2.put("author", "Ralls, Kim");
        book2.put("title", "Midnight Rain");

        Map<String, Object> books = new HashMap<>();
        books.put("book", Arrays.asList(book1, book2));
        paramMap.put("catalog", books);

        Writable writable = template.make(paramMap);
        writable.writeTo(writer);

        System.out.println("Output is : " + writable.toString());
    }

}
