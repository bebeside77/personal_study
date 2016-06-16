/*
 * @(#)ConcreteClass.java  2016.04.12
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.jdk8;

/**
 * @author yuwook
 */
public class ConcreteClass implements Interface1, Interface2 {
    @Override
    public void process() {
        System.out.println("from concrete class");
    }

    public static void main(String[] args) {
        new ConcreteClass().process();
    }
}
