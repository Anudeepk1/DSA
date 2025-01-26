package org.learning.trees;

public class HeapOrPriorityQueue {
    static int pointer = 1;
    public static void main(String[] args) {
        int[] heapQueue = new int[50];

        //formula ==> left = 2*i, right = 2*i+1, parent = i/2;
        push(heapQueue, 14);

    }

    public static void push(int[] arr, int data){
        if(pointer <= 50){
            arr[pointer] = data;
            percolateUp(arr, pointer);
            pointer++;
        } else {
            System.out.println("Cannot add element, element out of bound exception");
        }
    }

    public static void pop(int[] arr, int maxIndex){
        arr[1] = arr[maxIndex];
        arr[maxIndex] = 0;
        maxIndex = 1;
        pointer--;

        while(true){
            int leftChild = maxIndex*2;
            int rightChild = maxIndex*2+1;
            int smallest = maxIndex;

            if(leftChild <= pointer && arr[leftChild] < arr[smallest]){
                smallest = leftChild;
            }
            if(rightChild <= pointer && arr[rightChild] < arr[smallest]){
                smallest = rightChild;
            }
            if(smallest == maxIndex){
                break;
            }

            int temp = arr[maxIndex];
            arr[maxIndex] = arr[smallest];
            arr[smallest] = temp;
            maxIndex = smallest;
        }

        /*while((arr[maxIndex*2] < arr[maxIndex]) || (arr[maxIndex*2+1] < arr[maxIndex])){
            if((arr[maxIndex*2] < arr[maxIndex*2+1]) && (arr[maxIndex*2] < arr[maxIndex])){
                int temp = arr[maxIndex];
                arr[maxIndex] = arr[maxIndex*2];
                arr[maxIndex*2] = temp;
                maxIndex = maxIndex*2;
            } else if((arr[maxIndex*2] > arr[maxIndex*2+1]) && (arr[maxIndex*2+1] < arr[maxIndex])){
                int temp = arr[maxIndex];
                arr[maxIndex] = arr[maxIndex*2+1];
                arr[maxIndex*2+1] = temp;
                maxIndex = maxIndex*2+1;
            }
        }*/
    }

    private static void percolateUp(int[] arr, int index) {
        while(arr[index] < arr[index/2]){
            int temp = arr[index];
            arr[index] = arr[index/2];
            arr[index/2] = temp;
            index = index/2;
        }
    }
}
