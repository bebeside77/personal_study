/*
 * @(#)TimedThread.java  2016.01.13
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.concurrent.interrupt;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author yuwook
 */
public class TimedThread {
	private static final ScheduledExecutorService cancelExec = Executors.newScheduledThreadPool(10);

	public static void timedRun1(Runnable r, long timeout, TimeUnit unit) {
		final Thread taskThread = Thread.currentThread();

		cancelExec.schedule(new Runnable() {
			@Override
			public void run() {
				// 여기서 인터럽트를 걸더라도 timedRun을 호출한 부분에서 인터럽트 처리가 없으면 작업이 멈추지 않는다.
				taskThread.interrupt();
				System.out.println("interrupt!");
			}
		}, timeout, unit);

		r.run();
	}

	public static void timedRun2(final Runnable r, long timeout, TimeUnit unit) throws InterruptedException {
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
		cancelExec.schedule(new Runnable() {
			@Override
			public void run() {
				taskThread.interrupt();
				System.out.println("interrupt!");
			}
		}, timeout, unit);

		taskThread.join(unit.toMillis(timeout));
		task.rethrow();
	}

	public static void main(String[] args) throws InterruptedException {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				PrintWriter writer;

				try {
					writer = new PrintWriter("E:\\home1\\test.txt");
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					return;
				}

				for (int i = 999999999; i > 0; i--) {
					double d = i / 0.3412342969634d / 4.4877733d / 4.4877733d * 151521d;
					writer.println(d);
				}

				System.out.println("finish!");

				writer.close();
			}
		};

		timedRun2(r, 1000, TimeUnit.MILLISECONDS);
	}
}
