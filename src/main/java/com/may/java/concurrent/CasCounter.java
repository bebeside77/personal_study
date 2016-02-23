/*
 * @(#)CasCounter.java  2016.02.17
 *
 * Copyright 2016 NAVER Corp. All rights Reserved. 
 * NAVER PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.concurrent;

import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class CasCounter {
    private SimulatedCAS value;

    public SimulatedCAS getValue() {
        return value;
    }

    public int increment() {
        int v;

        do {
            v = value.get();
        } while (v != value.compareAndSwap(v, v + 1));

        return v + 1;
    }
}
