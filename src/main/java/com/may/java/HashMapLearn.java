/*
 * @(#)HashMapLearn.java  2016.11.29
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java;

import java.util.HashMap;

/**
 * @author yuwook
 */
public class HashMapLearn {

    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<String, String>();

        hashMap.put(new String("one"), "good");

        System.out.println(hashMap.get(new String("one")));
        System.out.println(new String("www").hashCode());
        System.out.println(new String("www").hashCode());

    }
}
