/*
 * @(#)ForkJoinBasic.java  2016.12.01
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.concurrent.forkjoin;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;

/**
 * @author yuwook
 */
@Slf4j
public class ForkJoinBasic {

    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.execute(() -> log.info("hello fork"));

        Thread.sleep(1000);

    }
}
