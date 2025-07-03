package Placements;

import java.util.Scanner;

public class series6 {
    // Tribonocci series
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[n];

        dp[0]=0;
        dp[1]=1;
        dp[2] =1;

        for(int i =3; i<n; i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }

        for(int i: dp){
            if(i!=4 && i!=0){
                System.out.println(i);
            }
        }
    }

}
