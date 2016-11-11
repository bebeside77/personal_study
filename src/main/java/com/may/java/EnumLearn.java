/*
 * @(#)EnumLearn.java  2016.11.01
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yuwook
 */
@Slf4j
public class EnumLearn {

    /**
     * 이건 왜 되는 거지
     *
     * @param args
     */
    public static void main(String[] args) {
        log.info(Drink.COFFEE.ICETEA.toString());
        log.info(Drink.MILKTEA.COFFEE.toString());
    }
}

enum Drink {
    COFFEE, ICETEA, MILKTEA
}