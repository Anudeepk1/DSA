package org.learning.algoTechniques;

public class KadaneAlgo {
    //to return the sun of highest sub array
    public static int kadane(int[] arr){
        int maxSum = 0;

        if(arr.length < 1){
            return 0;
        }
        int currSum =0;

        for(int i=0; i<arr.length; i++){
            currSum = Math.max(currSum, 0);
            currSum += arr[i];
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;

    }
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 5, -3, 2, -5, 4};
        int sum = kadane(arr);
        System.out.println(sum);
    }
}
