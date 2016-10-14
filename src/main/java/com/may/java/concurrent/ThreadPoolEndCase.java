/*
 * @(#)ThreadPoolEndCase.java  2016.06.16
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author yuwook
 */
@Slf4j
public class ThreadPoolEndCase {

    public void doSomethingWithThreadPoolAndShutdown() {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

        executor.execute(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {

            }
            log.info("thread run...");
        });

        executor.execute(() -> log.info("thread run..."));

        executor.shutdown();

        log.info("end of doSomething..");
    }

    public void doSomethingWithThreadPool() {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

        executor.execute(() -> log.info("thread run..."));
        executor.execute(() -> log.info("thread run..."));

        log.info("end of doSomething..");
    }

    public static void main(String[] args) {
        ThreadPoolEndCase threadPoolEndCase = new ThreadPoolEndCase();

        threadPoolEndCase.doSomethingWithThreadPool();
    }
}
