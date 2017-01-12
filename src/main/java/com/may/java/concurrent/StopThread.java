/*
 * @(#)StopThread.java  2016.11.30
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @author yuwook
 */
public class StopThread {
    private static boolean stopRequested;

    /**
     * BackgroundThread couldn't be terminated.
     * Because it is not sure backgroundThread can refer the change of stopRequested value.
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }

            System.out.println("the end of background thread");
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }

}
