package SlidingWindow;

import java.util.Scanner;

public class kDistinct {
    public int distinct (String s){
        int start = 0;

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
