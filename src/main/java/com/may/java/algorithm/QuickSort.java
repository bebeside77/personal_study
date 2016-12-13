package com.may.java.algorithm;

import java.util.Random;

/**
 * @author bebeside77
 */
public class QuickSort {
	private Random random = new Random();

	public void sort(int[] array) {
		sort(array, 0, array.length - 1);
	}

	public void sort(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}

		int lowIndex = start;
		int highIndex = end;
		int pivot = selectPivot(array, start, end);

		while (lowIndex <= highIndex) {
			while (array[lowIndex] < pivot) {
				lowIndex++;
			}
			while (pivot < array[highIndex]) {
				highIndex--;
			}

			if (lowIndex <= highIndex) {
				int temp = array[lowIndex];
				array[lowIndex] = array[highIndex];
				array[highIndex] = temp;

				lowIndex++;
				highIndex--;
			}
		}

		if (start < highIndex) {
			sort(array, start, highIndex);
		}
		if (end > lowIndex) {
			sort(array, lowIndex, end);
		}
	}

	private int selectPivot(int[] array, int start, int end) {
		return array[random.nextInt(end - start) + start];
	}
}
