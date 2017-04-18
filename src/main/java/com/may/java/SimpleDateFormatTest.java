/*
 * @(#)SimpleDateFormatTest.class 1.0.0 2017.04.18
 *
 * Copyright 2017 NAVER Corp. All rights Reserved. 
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yuwook Kang (yw.kang@navercorp.com)
 */
public class SimpleDateFormatTest {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = sdf.parse("201704181510"); // ParseException

		System.out.println(date);
	}
}
