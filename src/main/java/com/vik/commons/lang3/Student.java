package com.vik.commons.lang3;

import java.io.Serializable;

import org.apache.commons.lang3.builder.Builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Student implements Serializable {
    public final String firstName;
    public final String lastName;

    private Student(final String firstName, final String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 5).append(firstName).append(lastName).hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Student s = (Student) obj;
        return new EqualsBuilder().append(firstName, s.firstName).append(lastName, s.lastName).isEquals();
    }

    public static class StudentBuilder implements Builder<Student> {

        private String firstName;
        private String lastName;

        public StudentBuilder() {}

        public StudentBuilder addFirstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StudentBuilder addLastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        @Override
        public Student build() {
            return new Student(firstName, lastName);
        }

    }

}
