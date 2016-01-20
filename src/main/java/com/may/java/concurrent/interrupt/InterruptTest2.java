/*
 * @(#)InterruptTest2.java  2016.01.12
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.concurrent.interrupt;

/**
 * @author yuwook
 */
public class InterruptTest2 {

	public static void main(String[] args) {
		GoodThread2 goodThread = new GoodThread2();
		goodThread.start();

		System.out.println(Thread.currentThread());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("interrupted!");
		}

		goodThread.interrupt();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("interrupted!!!!!!");
		}
	}
}

class GoodThread2 extends Thread {

	@Override
	public void run() {
		try {
			sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("interrupted!");
			System.out.println(Thread.currentThread());

			try {
				sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			Thread.currentThread().interrupt();
			return;
		}

		System.out.println("finish!");
	}
}