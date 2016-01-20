/*
 * @(#)CompletionServiceTest.java  2016.01.12
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.concurrent;

import java.util.concurrent.*;

/**
 * @author yuwook
 */
public class CompletionServiceTest {
	private ExecutorService executorService = Executors.newFixedThreadPool(4);
	private CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

	public void addTask() {
		Future<String> f = completionService.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(2000);

				return "OK";
			}
		});

		try {
			System.out.println("1:" + f.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		try {
			Future<String> future = completionService.take();
			String str = future.get();
			System.out.println(str);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	public void stop() {
		executorService.shutdown();
	}

	public static void main(String[] args) {
		CompletionServiceTest completionServiceTest = new CompletionServiceTest();
		completionServiceTest.addTask();
	}
}
