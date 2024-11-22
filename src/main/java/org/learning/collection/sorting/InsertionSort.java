package org.learning.collection.sorting;

public class InsertionSort {

    // Insertion Sort Algorithm:
    // 1. Divide the array into a sorted and an unsorted section.
    // 2. Iterate through the unsorted section.
    // 3. For each element, "insert" it into its correct position in the sorted section.
    // 4. Shifts larger elements in the sorted section to make space for the insertion.
    // Time Complexity: O(n^2) (Worst and Average Case), O(n) (Best Case for nearly sorted data).
    // Space Complexity: O(1) (In-place sort).
    // Stable sorting algorithm; suitable for small datasets or nearly sorted data.

    public static int[] sort(int[] arr){
        int pointer;

        if(arr == null || arr.length <2){
            return arr;
        }

        for(int i=1; i<arr.length; i++){
            pointer = arr[i];
            int j = i-1;
            while (j>=0 && pointer < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = pointer;

        }
        return arr;
    }

}
