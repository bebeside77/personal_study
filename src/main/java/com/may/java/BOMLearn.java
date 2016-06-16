/*
 * @(#)BOMLearn.java  2016.04.21
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author yuwook
 */
@Slf4j
public class BOMLearn {

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("D:\\aa.txt");

        BufferedReader bufferedReader = new BufferedReader(reader);

        String line = bufferedReader.readLine();

        log.info(line);

        for (char c : line.toCharArray()) {
            log.info(Integer.toHexString(c));
        }

    }
}
