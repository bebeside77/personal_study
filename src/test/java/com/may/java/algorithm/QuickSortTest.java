package com.may.java.algorithm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author bebeside77
 */
@RunWith(Parameterized.class)
public class QuickSortTest {
	private QuickSort quickSort = new QuickSort();

	@Parameterized.Parameters
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] {
				{new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, new int[] {10, 8, 9, 5, 4, 3, 1, 2, 7, 6}}
		});
	}

	private int[] expected;
	private int[] numbers;

	public QuickSortTest(int[] expected, int[] numbers) {
		this.expected = expected;
		this.numbers = numbers;
	}

	@Test
	public void sort() throws Exception {
		quickSort.sort(numbers);
		assertArrayEquals(expected, numbers);
	}


}