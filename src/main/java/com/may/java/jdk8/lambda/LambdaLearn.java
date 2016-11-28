/*
 * @(#)LambdaLearn.java  2016.11.14
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.jdk8.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author yuwook
 */
public class LambdaLearn {

    public void consume(Consumer<String> consumer) {
        consumer.accept("underwood");
    }

    public void produce(Supplier<String> supplier) {
        System.out.println("supplied the " + supplier.get());
    }

    public void predicate(Predicate<String> predicate) {
        if (predicate.test("TEST")) {
            System.out.println("do something!");
        } else {
            System.out.println("do not something!");
        }
    }

    public Boolean transform(Function<String, Boolean> function) {
        return function.apply("true");
    }

    public static void main(String[] args) {
        LambdaLearn lambdaLearn = new LambdaLearn();
        lambdaLearn.consume(s -> System.out.println("consume the " + s));
        lambdaLearn.produce(() -> "clair");
        lambdaLearn.predicate(s -> s.equals("TEST"));
        lambdaLearn.predicate(s -> s.equals("BEST"));
        lambdaLearn.transform(String::isEmpty);
    }


}
