package Exam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class prime {
    public static int sums (int[] arr){
        int ans = 0;
        int add = 0;

        for(int i =0; i<arr.length; i++){
            ans = primes(arr[i]);
            if(ans!=-1){
                add+= arr[i];
            } 
        }
    }
    public static int primes(int n){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i =1; i<n+1; i++){
            if(n%i == 0){
                arr.add(i);
            }
        }
        if(arr.size()== 2){
 
            if((arr.get(0) ==1 && arr.get(1) == n)||
            (arr.get(1) ==1 && arr.get(0) == n)) return 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = sums(arr);
        System.out.println(ans);
        if (ans==1){
            System.out.println("is prime");

        }
        else{
            System.out.println("not prime");
        }
        sc.close();
    }
}
