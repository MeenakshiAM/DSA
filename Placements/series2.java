package Placements;

import java.util.Scanner;

public class series2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans =2;
        for(int j=1; j<=n;j++){
            if(j==ans){
                ans+=3;
                int k =(-1) * j;
                System.out.println(k);
            }
            else if(j%4 != 0){
            System.out.println(j);
            }
            
        }


    }
}
