package Placements;
import java.util.*;


public class series {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n =  sc.nextInt(); 
        int dp[]=  new int [n];

        dp[0] =1;
        dp[1]=4;
        for(int i = 2; i<n ; i++){
            dp[i] = dp[i-1]+2;
        }

        for(int i : dp){
            System.out.println(i);
        }
        sc.close();
    }
}
