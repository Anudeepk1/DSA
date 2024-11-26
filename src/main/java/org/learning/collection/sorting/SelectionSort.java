package org.learning.collection.sorting;

public class SelectionSort {

    // Selection Sort Algorithm:
    // 1. Divide the array into a sorted and an unsorted section.
    // 2. Find the minimum element in the unsorted section.
    // 3. Swap it with the first element of the unsorted section.
    // 4. Expand the sorted section by one element and repeat until the array is sorted.
    // Time Complexity: O(n^2) (Best, Worst, and Average Case).
    // Space Complexity: O(1) (In-place sort).
    // Not a stable sorting algorithm (does not preserve the order of equal elements).
    // Simple to implement but inefficient for large datasets.

    public static int[] sort(int[] arr){

        if(arr == null || arr.length<2){
            return arr;
        }
        int minIndex = 0;
        for(int i=0; i< arr.length-1; i++){
            minIndex = i;
            for(int j=i+1; j< arr.length; j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

        }

        return arr;
    }
}
