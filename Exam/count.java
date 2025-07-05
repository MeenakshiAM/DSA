package Exam;

import java.util.HashMap;
import java.util.Scanner;

public class count {

    public static int counts(int[] arr, int ele, int c, int i){
        if(arr[i] == ele) c++;
        i++;
        if(i<arr.length) return counts( arr, ele, c, i);
        return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int ele = sc.nextInt();
        int c =0,i=0;
        int ans = counts(arr,ele,c,i);

        System.out.println(ans);
        
        sc.close();
    }
}
