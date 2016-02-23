/*
 * @(#)ReentrantLockPseudoRandom.java  2016.02.17
 *
 * Copyright 2016 NAVER Corp. All rights Reserved. 
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockPseudoRandom {

    private final Lock lock = new ReentrantLock(false);
    private int seed;

    public ReentrantLockPseudoRandom(int seed) {
        this.seed = seed;
    }

    public int nextInt(int n) {
        lock.lock();

        try {
            int s = seed;
            seed = calculateNext(s);
            int remainder = s % n;

            return remainder > 0 ? remainder : remainder + n;
        } finally {
            lock.unlock();
        }
    }

    private int calculateNext(int s) {
        //

        return 0;
    }
}
