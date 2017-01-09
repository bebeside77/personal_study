package com.may.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author bebeside77
 */
public class SingleThreadPool {

	public void execute() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		executorService.execute(() -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("i'm going to slightly mad.");
		});

		// if doesn't shutdown executorService explicitly it doesn't be quited.
		//		executorService.shutdown();
	}

	public static void main(String[] args) throws InterruptedException {
		SingleThreadPool singleThreadPool = new SingleThreadPool();
		singleThreadPool.execute();

		Thread.sleep(10000);

	}
}
