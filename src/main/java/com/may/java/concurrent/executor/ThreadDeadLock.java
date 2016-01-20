/*
 * @(#)ThreadDeadLock.java  2016.01.19
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
public class ThreadDeadLock {
	ExecutorService exec = Executors.newSingleThreadExecutor();

	public class RenderPageTask implements Callable<String> {

		@Override
		public String call() throws Exception {
			Future<String> header, footer;

			header = exec.submit(new LoadFileTask("header.html"));
			footer = exec.submit(new LoadFileTask("footer.html"));
			String page = renderBody();

			// 이미 renderPage에서 스레드1개를 점유하고 있어서 다음 라인은 영영 실행되지 않는다.
			// => 데드락 발생
			return header.get() + page + footer.get();
		}
	}

	private class LoadFileTask implements Callable<String> {
		private String s;

		public LoadFileTask(String s) {
			this.s = s;
		}

		@Override
		public String call() throws Exception {
			return s;
		}

	}

	private String renderBody() {
		return "body";
	}

	public String renderPage() throws ExecutionException, InterruptedException {
		Future<String> future = exec.submit(new RenderPageTask());

		log.info("renderPage start");

		return future.get();
	}

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ThreadDeadLock threadDeadLock = new ThreadDeadLock();
		String page = threadDeadLock.renderPage();

		log.info("page : " + page);
	}

}
