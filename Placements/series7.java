package Placements;

import java.util.Scanner;

public class series7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int neg =-4;
        int pos = 3;
        int dp[] = new int[n];
        dp[0] = 1;
        dp[1] = -2;


        for(int i = 2; i<n; i++){
            if(i%2 ==0){
                dp[i] = dp[i-2]+pos;
            }
            else{
                 dp[i] = dp[i-2]+neg;
            }
        }

        for(int i : dp){
            System.out.println(i);
        }
    }
}
