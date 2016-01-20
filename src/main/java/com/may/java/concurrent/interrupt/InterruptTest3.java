/*
 * @(#)InterruptTest3.java  2016.01.19
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.concurrent.interrupt;

import lombok.extern.slf4j.Slf4j;

/**
 * Thread.currentThread().isInterrupted() 를 호출한다고해서 인터럽트 상태가 초기화되는 것은 아니다.
 * Thread.interrupted() 를 호출하면 초기화 된다.
 *
 * @author yuwook
 */
@Slf4j
public class InterruptTest3 {

	public static void main(String[] args) throws InterruptedException {
		log.info("main isInterrupted : " + Thread.currentThread().isInterrupted());

		WorkerThread workerThread = new WorkerThread(new CheckThread());

		Thread thread = new Thread(workerThread);
		thread.start();

		Thread.sleep(2000);

		thread.interrupt();

		Thread.sleep(2000);

		log.info("main isInterrupted : " + Thread.currentThread().isInterrupted());
	}
}

@Slf4j
class WorkerThread implements Runnable {
	private Runnable runnable;

	public WorkerThread(Runnable runnable) {
		this.runnable = runnable;
	}

	@Override
	public void run() {
		runnable.run();

		log.info("WorkerThread isInterrupted : " + Thread.currentThread().isInterrupted());
	}
}

@Slf4j
class CheckThread implements Runnable {

	@Override
	public void run() {
		while (true) {
			if (Thread.currentThread().isInterrupted()) {
				log.info("CheckThread interrupted!");
				log.info("CheckThread isInterrupted : " + Thread.currentThread().isInterrupted());

				break;
			}
		}
	}
}