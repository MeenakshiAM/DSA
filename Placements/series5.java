package Placements;

import java.util.Scanner;

public class series5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[n];
        dp[0] = -4;
        double val =4.0;
        for (int i = 1; i<n; i++){
            dp[i]= (int)Math.pow(val,i+1);
        }

        for(int i : dp){
            System.out.println(i);
        }
    }
}
