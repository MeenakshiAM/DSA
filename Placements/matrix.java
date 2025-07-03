package Placements;

import java.util.Scanner;

public class matrix {
    public int fib(int x){
        if(x == 0) return 0;
        if(x==1 || x==2) return 1;
        return fib(x-1)+fib(x-2)+fib(x-3);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        matrix obj = new matrix();
        
        int x =0;

        for(int i = 0; i<row; i++){
            for(int j = 0; j<i; j++){
                int ans =  obj.fib(x);
                System.out.print(ans + " ");
                x++;
            }
            System.out.println(" ");
        }

        
    }
    
}
