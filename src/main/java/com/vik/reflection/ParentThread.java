package com.vik.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ParentThread {

    public static void main(final String[] args)
            throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("com.vik.reflection.ChildThread");
        Method runMethod = clazz.getMethod("run");
        Object constructor = clazz.newInstance();
        try {
            runMethod.invoke(constructor);
        } catch (InvocationTargetException e) {
            System.out.println("Inside invocation Target Exception");
            // e.printStackTrace();
            Throwable th = e.getTargetException();
            if (th instanceof RuntimeException) {
                System.out.println("Inside throwable's Run time Exception");
            }
        } catch (RuntimeException e) {
            System.out.println("Inside Run Time Exception");
        }
    }

}
