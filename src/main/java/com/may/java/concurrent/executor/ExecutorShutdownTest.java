/*
 * @(#)ExecutorShutdownTest.java  2016.01.21
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.concurrent.executor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author yuwook
 */
@Slf4j
public class ExecutorShutdownTest {

	public void runWithExecutor() {
		ExecutorService executorService = Executors.newFixedThreadPool(4);

		Future<String> future = executorService.submit(() -> {
			Thread.sleep(2000);

			log.info("callable call.");

			return "OK";
		});

		try {
			log.info("future result : " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			log.info("", e);
		}

		log.info("end of runWithExecutor");
		log.info("active count : " + ((ThreadPoolExecutor)executorService).getActiveCount() + "");
		log.info("completed count : " + ((ThreadPoolExecutor)executorService).getCompletedTaskCount() + "");

		executorService.shutdown(); // shutdown을 하지 않으면 프로그램이 종료되지 않는다.
	}

	public static void main(String[] args) {
		ExecutorShutdownTest executorShutdownTest = new ExecutorShutdownTest();
		executorShutdownTest.runWithExecutor();

	}
}
