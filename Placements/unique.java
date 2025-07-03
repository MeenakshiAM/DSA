package Placements;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class unique {
    public int identicalCount(int[] arr){
       
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
           int value = entry.getValue();
           if(value ==1){
            return entry.getKey();
           }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        unique obj = new unique();
       int ans = obj.identicalCount(arr);
       System.out.println("ans is :"+ans);
       
    }
}
