/*
 * @(#)PalindromeCheckTest.java  2016.11.30
 *
 * Copyright 2016 NHN Corp. All rights Reserved. 
 * NHN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.may.java.algorithm;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author yuwook
 */
public class PalindromeCheckTest {
    private PalindromeCheck palindromeCheck = new PalindromeCheck();

    @Test
    public void isPalindrome() throws Exception {
        assertThat(palindromeCheck.isPalindrome("eye"), is(true));
        assertThat(palindromeCheck.isPalindrome("level"), is(true));
        assertThat(palindromeCheck.isPalindrome("abaaba"), is(true));
        assertThat(palindromeCheck.isPalindrome("good"), is(false));
    }


}