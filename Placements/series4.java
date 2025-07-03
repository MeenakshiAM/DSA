package Placements;

import java.util.Scanner;

public class series4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double ans = 1.0;
        

        for(int i =1; i<=n; i++){
            if(i%4 ==0){    
                continue;
            }
            else{
                ans = Math.pow(i, 2);
                System.out.println((int)ans);
            }
        }

    }
}
