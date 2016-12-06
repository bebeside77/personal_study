package com.may.java.algorithm;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author bebeside77
 */
public class BinarySearchTest {
    private BinarySearch binarySearch = new BinarySearch();

    @Test
    public void search() throws Exception {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        assertThat(binarySearch.search(array, 0, array.length - 1, 3), is(3));
        assertThat(binarySearch.search(array, 0, array.length - 1, 10), is(10));
        assertThat(binarySearch.search(array, 0, array.length - 1, 14), is(14));
    }


}