package Placements;

import java.util.Scanner;
//1,2,4,
//1,3,6,10
public class cumSum {
    public int[] cArray(int[] arr){
        int dp[] = new int[arr.length-1]; 
        dp[0] =1;
        for(int i =1; i<arr.length-1; i++){
            dp[i]= dp[i-1]+arr[i];
        }
        return dp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        cumSum obj = new cumSum();
       int[] ans= obj.cArray(arr);
       System.out.println("the op is");
       for(int i : ans){
        System.out.println(i);
       }
    }
}
