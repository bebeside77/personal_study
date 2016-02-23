package com.may.java.concurrent.deadlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class LeftRightDeadlock {
    private final Object left = new Object();
    private final Object right = new Object();

    public void leftRight() {
        synchronized (left) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (right) {
                doSomething();
            }
        }
    }

    public void rightLeft() {
        synchronized (right) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (left) {
                doSomething();
            }
        }
    }

    private void doSomething() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("doSomething ends.");
    }

    public static void main(String[] args) {
        LeftRightDeadlock leftRightDeadlock = new LeftRightDeadlock();

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                leftRightDeadlock.leftRight();
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                leftRightDeadlock.rightLeft();
            }
        });

        executor.shutdown();

    }
}
