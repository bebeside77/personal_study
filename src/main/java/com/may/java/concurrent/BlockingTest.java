/*
 * @(#)BlockingTest.java  2016.01.12
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author yuwook
 */
public class BlockingTest {
	private BlockingQueue blockingQueue = new LinkedBlockingQueue<>();

	public Object take() throws InterruptedException {
		return blockingQueue.take();
	}

	public static void main(String[] args) {
		System.out.println("start!");

		new Thread() {
			@Override
			public void run() {
				try {
					new BlockingTest().take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();

		System.out.println("finish!");
	}
}
