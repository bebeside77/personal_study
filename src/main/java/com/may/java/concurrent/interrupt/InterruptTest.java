/*
 * @(#)InterruptTest.java  2016.01.12
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.concurrent.interrupt;

/**
 * @author yuwook
 */
public class InterruptTest {

	public static void main(String[] args) throws InterruptedException {
		GoodThread goodThread = new GoodThread();
		goodThread.start();

		Thread.sleep(2000);

		goodThread.interrupt();
	}
}

class GoodThread extends Thread {

	@Override
	public void run() {
		try {
			sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("interrupted!");
			return;
		}

		System.out.println("finish!");
	}
}