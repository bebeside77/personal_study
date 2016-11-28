/*
 * @(#)ParseIntTest.java  2016.11.28
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.may.java.algorithm;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author yuwook
 */
public class ParseIntTest {
    private ParseInt parseInt = new ParseInt();

    @Test
    public void itoa() throws Exception {
        assertThat(parseInt.itoa(12345), is("12345"));
        assertThat(parseInt.itoa(453445), is("453445"));
        assertThat(parseInt.itoa(231421), is("231421"));
        assertThat(parseInt.itoa(-12345), is("-12345"));
    }

    @Test
    public void parse() throws Exception {
        assertThat(parseInt.parse("12345"), is(12345));
        assertThat(parseInt.parse("01235"), is(1235));
        assertThat(parseInt.parse("5654654"), is(5654654));
        assertThat(parseInt.parse("12534248"), is(12534248));
        assertThat(parseInt.parse("912531512"), is(912531512));
        assertThat(parseInt.parse("-52435423"), is(-52435423));
        assertThat(parseInt.parse("+24354235"), is(24354235));
    }

    @Test(expected = NumberFormatException.class)
    public void parse_exception() throws Exception {
        assertThat(parseInt.parse("54w87"), is(0));
    }

    @Test
    public void atoi() throws Exception {
        assertThat(parseInt.atoi("12345"), is(12345));
        assertThat(parseInt.atoi("01235"), is(1235));
        assertThat(parseInt.atoi("5654654"), is(5654654));
        assertThat(parseInt.atoi("12534248"), is(12534248));
        assertThat(parseInt.atoi("912531512"), is(912531512));
        assertThat(parseInt.atoi("-52435423"), is(-52435423));
        assertThat(parseInt.atoi("+24354235"), is(24354235));
    }


}