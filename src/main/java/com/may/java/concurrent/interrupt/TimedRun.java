/*
 * @(#)TimedRun.java  2016.01.19
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.concurrent.interrupt;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yuwook
 */
@Slf4j
public class TimedRun {
	private static final ScheduledExecutorService cancelExec = new ScheduledThreadPoolExecutor(10);

	public static void timedRun(Runnable r, long timeout, TimeUnit unit) {
		final Thread taskThread = Thread.currentThread();

		cancelExec.schedule((Runnable) new Runnable() {
			@Override
			public void run() {
				taskThread.interrupt(); // 인터럽트를 걸어도 종료되지 않음
			}
		}, timeout, unit);

		r.run();
	}

	public static void main(String[] args) {
		log.info("start");

		TimedRun.timedRun(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					log.info("interrupted1!"); //

					try {
						Thread.sleep(5000); // 작업 스레드에서 인터럽트에 제대로 반응하지 않을 수도 있다
					} catch (InterruptedException e1) {
						log.info("interrupted2!");
					}
				}
			}
		}, 3, TimeUnit.SECONDS);

		log.info("end"); // 이 부분이 인터럽트 걸린 즉시 실행되지 않는다.

		cancelExec.shutdown();
	}
}
