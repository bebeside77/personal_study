package com.may.java.algorithm;

/**
 * @author bebeside77
 */
public class BinarySearch {

    public int search(int[] array, int startIndex, int endIndex, int target) {
        if (endIndex < startIndex) {
            return -1;
        }

        int middle = (startIndex + endIndex) / 2;

        if (array[middle] == target) {
            return middle;
        } else if (array[middle] > target) {
            return search(array, startIndex, middle - 1, target);
        } else {
            return search(array, middle + 1, endIndex, target);
        }
    }

}
