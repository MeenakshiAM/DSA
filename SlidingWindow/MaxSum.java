package SlidingWindow;

import java.util.Scanner;


public class MaxSum {
    public int subarray(int[] arr, int k){
        int total=0;
        int maximum =Integer.MIN_VALUE;
    
        for (int i = 0; i<k; i++){
            total += arr[i];
        }
        maximum = total;

        for(int i =k; i<arr.length; i++){
            total = total + arr[i] -arr[i-k];
            maximum = Math.max(total, maximum);
        }
        return maximum;
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("enther the window size:");
        int k = sc.nextInt();
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        MaxSum obj = new MaxSum();
       int ans = obj.subarray(arr,k);
       System.out.println("ans is :"+ans); 
    }
}
