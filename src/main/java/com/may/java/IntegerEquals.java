/*
 * @(#)IntegerEquals.class 1.0.0 2017.04.18
 *
 * Copyright 2017 NAVER Corp. All rights Reserved. 
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java;

/**
 * @author Yuwook Kang (yw.kang@navercorp.com)
 */
public class IntegerEquals {

	/**
	 * To compare Wrapper class use equals rather than ==.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Integer integer1 = new Integer(20);
		Integer integer2 = new Integer(20);

		System.out.println(integer1);
		System.out.println(integer2);
		System.out.println(integer1 == integer2); // false
		System.out.println(integer1.equals(integer2)); // true
	}
}
