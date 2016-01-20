/*
 * @(#)TimedRun3.java  2016.01.19
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.concurrent.interrupt;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author yuwook
 */
@Slf4j
public class TimedRun3 {
	private static final ExecutorService taskExec = Executors.newFixedThreadPool(4);

	public static void timedRun(Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
		Future<?> task = taskExec.submit(r);

		try {
			task.get(timeout, unit);
		} catch (ExecutionException e) {
			// 작업 내부에서 예외 발생 시 다시 던짐.
			throw new RuntimeException(e);
		} catch (TimeoutException e) {
			// finally 에서 작업이 중단된다.
		} finally {
			task.cancel(true); // 실행 중이라면 인터럽트를 건다.
		}
	}

	public static void main(String[] args) throws InterruptedException {
		log.info("start");

		TimedRun3.timedRun(() -> {
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

		taskExec.shutdown();
	}
}
