package com.test;

public abstract class AbstractResultSource {

    public void store() {

        System.out.println("Inside abstract -- 1");
        addMultiPart();
        System.out.println("Inside abstract -- 2");

    }

    public abstract void addMultiPart();

}
