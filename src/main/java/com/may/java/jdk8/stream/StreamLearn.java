/**
 * @(#) StreamLearn.class 1.0.0 2019. 06. 27.
 *
 * Copyright 2019 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.jdk8.stream;

import java.util.stream.Stream;

/**
 * @author Yuwook Kang (yw.kang@navercorp.com)
 */
public class StreamLearn {

	public static void main(String[] args) {
		Stream<Double> randoms = Stream.generate(Math::random);
		System.out.println(randoms.limit(100).count());
	}
}
