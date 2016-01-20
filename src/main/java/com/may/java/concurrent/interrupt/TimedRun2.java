/*
 * @(#)TimedRun2.java  2016.01.19
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
public class TimedRun2 {
	private static final ScheduledExecutorService cancelExec = new ScheduledThreadPoolExecutor(10);

	public static void timedRun(final Runnable r, long timeout, TimeUnit unit) throws InterruptedException {

		class RethrowableTask implements Runnable {
			private volatile Throwable t;

			@Override
			public void run() {
				try {
					r.run();
				} catch (Throwable t) {
					this.t = t;
				}
			}

			void rethrow() {
				if (t != null) {
					throw new RuntimeException(t);
				}
			}
		}

		RethrowableTask task = new RethrowableTask();
		final Thread taskThread = new Thread(task);
		taskThread.start();
		cancelExec.schedule(() -> taskThread.interrupt(), timeout, unit);

		taskThread.join(unit.toMillis(timeout)); // 작업이 실행되는 동안 기다린다.

		// join이 끝났을 때 정상적으로 스레드가 종료된 것인지, join 타임아웃이 걸려 끝난 것인지 알 수 없다는 문제가 있다.

		task.rethrow(); // 예외가 발생했다면 다시 던진다.
	}

	public static void main(String[] args) throws InterruptedException {
		log.info("start");

		TimedRun2.timedRun(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				log.info("interrupted1!"); //

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					log.info("interrupted2!");
				}
			}
		}, 3, TimeUnit.SECONDS);

		log.info("end"); // 이 부분이 인터럽트 걸림과 동시에 실행된다.

		cancelExec.shutdown();
	}
}
