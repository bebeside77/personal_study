package com.may.java.concurrent.executor;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class ParallelPerformance {

    public static void sequentialProcess(int count) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            log.info("[sequentialProcess] res : " + calculateSomething());
        }

        log.info("[sequentialProcess] " + (System.currentTimeMillis() - startTime) + " mills passed.");
    }

    public static void parallelProcess(int count) {
        long startTime = System.currentTimeMillis();

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(count);

        List<Future<Double>> futures = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Future<Double> future = threadPoolExecutor.submit(new Callable<Double>() {
                @Override
                public Double call() throws Exception {
                    return calculateSomething();
                }
            });

            futures.add(future);
        }

        for (Future future : futures) {
            try {
                log.info("[parallelProcess] res : " + String.valueOf(future.get()));
            } catch (ExecutionException | InterruptedException e) {
                log.error("", e);
            }
        }

        threadPoolExecutor.shutdown();

        log.info("[parallelProcess] " + (System.currentTimeMillis() - startTime) + " mills passed.");
    }

    private static double calculateSomething() {
        double tmp = 1322;

        for (int j = 0; j < 0xFFFFFFF; j++) {
            tmp *= tmp / tmp * tmp / tmp * tmp / tmp * tmp / tmp * tmp / tmp * tmp / tmp * tmp / tmp * tmp / tmp * tmp;
        }

        return tmp;
    }

    public static void main(String[] args) throws InterruptedException {
        ParallelPerformance.sequentialProcess(4);
        ParallelPerformance.parallelProcess(4);
    }
}
