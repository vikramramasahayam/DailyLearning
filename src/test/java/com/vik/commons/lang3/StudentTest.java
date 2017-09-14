package com.vik.commons.lang3;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Assert;
import org.junit.Test;

import com.vik.commons.lang3.Student.StudentBuilder;

public class StudentTest {

    @Test
    public void testBuilder() {
        StudentBuilder builder = new StudentBuilder();
        Student student1 = builder.addFirstName("Raj").addLastName("Virat").build();
        Student student2 = builder.addFirstName("Raj").addLastName("Virat").build();

        Assert.assertTrue(student1.equals(student2));
    }

    @Test
    public void testSerialization() {
        Student student1 = new StudentBuilder().addFirstName("Raj").addLastName("Virat").build();
        byte[] serializedStudent = SerializationUtils.serialize(student1);
        Student student2 = (Student) SerializationUtils.deserialize(serializedStudent);
        Assert.assertTrue(student1.equals(student2));
    }
}
