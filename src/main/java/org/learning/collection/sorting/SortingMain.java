package org.learning.collection.sorting;

import java.util.Arrays;

public class SortingMain {
    public static void main(String[] args){
        int[] arr = {25, 7, 19, 3, 12, 8, 45, 31, 10, 18};
//        System.out.println(Arrays.toString(BubbleSort.sort(arr)));
        System.out.println(Arrays.toString(InsertionSort.sort(arr)));

    }
}
