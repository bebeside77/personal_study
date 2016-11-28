/*
 * @(#)ParseInt.java  2016.11.28
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package com.may.java.algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yuwook
 */
@Slf4j
public class ParseInt {

    public String itoa(int integer) {
        String result = "";

        int abs = integer < 0 ? integer * -1 : integer;
        int i = 1;

        while (abs / i > 0) {
            int digit = (abs / i) % 10;

            char c = (char) ('0' + digit);

            result = c + result;

            i *= 10;
        }

        return integer < 0 ? '-' + result : result;

    }

    public int parse(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int result = 0;
        boolean negative = false;

        for (int i = 0; i < str.length(); i++) {
            char aChar = str.charAt(i);

            if (i == 0 && aChar == '-') {
                negative = true;
                continue;
            } else if (i == 0 && aChar == '+') {
                negative = false;
                continue;
            }

            if (aChar < '0' || aChar > '9') {
                throw new NumberFormatException(aChar + " is not a number.");
            } else {
                char number = (char) (aChar - '0');

                if (result * 10 + number > Integer.MAX_VALUE) {
                    result = Integer.MAX_VALUE;
                } else {
                    result = result * 10 + number;
                }
            }
        }

        return negative ? result * -1 : result;
    }

    public int atoi(String str) {
        if (str == null || str.length() < 1)
            return 0;

        // trim white spaces
        str = str.trim();

        char flag = '+';

        // check negative or positive
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }
        // use double to store result
        double result = 0;

        // calculate value
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-')
            result = -result;

        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) result;
    }

}
