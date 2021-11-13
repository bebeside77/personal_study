/**
 * @(#) MyQueueTest.class 1.0.0 2021. 11. 13.
 *
 * Copyright 2021 NAVER Corp. All rights Reserved.
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.algoritm;

import org.junit.Test;

import com.may.java.algorithm.MyQueue;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Yuwook Kang (yw.kang@navercorp.com)
 */
@Slf4j
public class MyQueueTest {

	@Test
	public void name() {

		MyQueue myQueue = new MyQueue();
		myQueue.add("aaa");
		myQueue.add("bbb");
		myQueue.add("ccc");

		log.info(myQueue.get());
		log.info(myQueue.get());
		log.info(myQueue.get());
		log.info(myQueue.get());

		myQueue.add("123");
		log.info(myQueue.get());
	}
}
