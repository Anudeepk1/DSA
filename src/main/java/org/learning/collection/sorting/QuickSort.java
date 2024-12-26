    package org.learning.collection.sorting;

    import java.util.Arrays;

    public class QuickSort {
    //TODO:BUG IN QUICK SORT NEED TO BE FIXED
        // Quick Sort Algorithm:
        // 1. Select a "pivot" element from the array (commonly the first, last, or middle element, or a random element).
        // 2. Partition the array into two subarrays:
        //    - Elements less than or equal to the pivot go to the left subarray.
        //    - Elements greater than the pivot go to the right subarray.
        // 3. Recursively apply the above steps to the left and right subarrays until the base case is reached (array of size 0 or 1).
        // 4. Combine the sorted subarrays and pivot to form the final sorted array.
        // Time Complexity: O(n^2) (Worst Case when the pivot divides the array poorly, e.g., already sorted/reverse sorted array),
        //                  O(n log n) (Average and Best Case when the pivot divides the array evenly).
        // Space Complexity: O(log n) (Best and Average Case for recursive calls in balanced partitions),
        //                   O(n) (Worst Case for recursive calls in unbalanced partitions).
        // Not a stable sorting algorithm; suitable for large datasets due to its average-case efficiency.

        public static int[] sort(int[] arr){
            return quickSort(arr, 0, arr.length-1);
        }

        public static int[] quickSort(int[] arr, int from, int to){
            if (from >= to) {
                return arr;
            }
            int pivot = arr[to];
            int frontIndex = from;
            int rearIndex = to-1;
            while(frontIndex <= rearIndex){
                if(arr[frontIndex] > pivot && arr[rearIndex] <  pivot){
                    int temp = arr[rearIndex];
                    arr[rearIndex] = arr[frontIndex];
                    arr[frontIndex] = temp;
                }
                if(arr[frontIndex] < pivot){
                    frontIndex++;
                }
                if(arr[rearIndex] > pivot){
                    rearIndex--;
                } else {
                    // Swap and move both pointers
                    int temp = arr[frontIndex];
                    arr[frontIndex] = arr[rearIndex];
                    arr[rearIndex] = temp;
                    frontIndex++;
                    rearIndex--;
                }
            }
            arr[to] = arr[frontIndex];
            arr[frontIndex] =pivot;


            if(from < frontIndex){
                quickSort(arr, from, frontIndex-1);

            }
            if(frontIndex+1 < to){
                quickSort(arr, frontIndex+1, to);
            }
            return arr;
        }


    }
