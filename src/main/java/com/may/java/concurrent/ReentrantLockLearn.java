/*
 * @(#)ReentrantLockLearn.java  2016.02.23
 *
 * Copyright 2016 NAVER Corp. All rights Reserved. 
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuwook
 */
@Slf4j
public class ReentrantLockLearn {
    private Lock lock = new ReentrantLock(true); // 생성자 인자로 공정성 여부를 지정할 수 있다.

    public void cleaning() {
        lock.lock();

        try {
            soup();
            drying();

            log.info("cleaning");
        } finally {
            lock.unlock();
        }
    }

    public void soup() {
        lock.lock();

        try {
            log.info("soup");
        } finally {
            lock.unlock();
        }
    }

    public void drying() {
        lock.lock();

        try {
            log.info("drying");
        } finally {
            lock.unlock();
        }
    }

    /**
     * ReentrantLock은 같은 스레드에서 재진입 가능하다.
     *
     * @param args
     */
    public static void main(String[] args) {
        ReentrantLockLearn learn = new ReentrantLockLearn();
        learn.cleaning();

    }
}
