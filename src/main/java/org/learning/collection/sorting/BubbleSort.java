package org.learning.collection.sorting;

import java.util.Arrays;

public class BubbleSort {

    // Bubble Sort Algorithm:
    // 1. Repeatedly compare adjacent elements in the array.
    // 2. Swap them if they are in the wrong order.
    // 3. Largest element "bubbles up" to the end in each iteration.
    // 4. Optimized version stops early if no swaps occur in an iteration.
    // Time Complexity: O(n^2) (Worst and Average Case), O(n) (Best Case for sorted data).
    // Space Complexity: O(1) (In-place sort).
    // Suitable for small datasets; inefficient for large datasets.

    public static int[] sort(int[] array){
        int pointer1, pointer2;
        int temp;
        boolean swapped = false;

        if (array == null || array.length < 2) {
            return array;
        }

        for(int i=0; i<array.length-1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                swapped = false;
                pointer1 = j;
                pointer2 = j + 1;
                if (array[pointer1] > array[pointer2]) {
                    temp = array[pointer2];
                    array[pointer2] = array[pointer1];
                    array[pointer1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return array;

    }
}
