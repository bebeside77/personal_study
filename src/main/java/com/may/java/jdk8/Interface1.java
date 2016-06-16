/*
 * @(#)Interface1.java  2016.04.12
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.jdk8;

/**
 * @author yuwook
 */
public interface Interface1 {

    default void process() {
        System.out.println("from interface 1");
    }
}
