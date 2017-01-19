package com.vik.daily.learning.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class SpringExpressionTest {
    ExpressionParser parser;

    @Before
    public void setup() {
        parser = new SpelExpressionParser();
    }

    @Test
    public void testExpression() {
        User user = new User("Jack", "Biran", false);
        Expression exp = parser.parseExpression("firstName");
        String firstName = (String) exp.getValue(user);
        Assert.assertEquals(user.getFirstName(), firstName);
        exp = parser.parseExpression("isAdmin() ==false");
        Assert.assertTrue(exp.getValue(user, Boolean.class));
    }

    private class User {

        private String firstName;
        private String lastName;
        private boolean isAdmin;

        public User(final String firstName, final String lastName, final boolean isAdmin) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.isAdmin = isAdmin;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public boolean isAdmin() {
            return isAdmin;
        }

    }

}
