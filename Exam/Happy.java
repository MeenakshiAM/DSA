package Exam;

import java.util.Scanner;

public class Happy {
    
    public static int divide(int n){
        int prod = 0;
        while(n >0){
            int k = n % 10;
            prod += Math.pow(k,2);
            n = n / 10;
        }
        System.out.println(prod);
        if(prod == 1){
            return 1;
        }
        else if (prod > 1){
            return divide(prod);
        }
        return prod==1?1:-1;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int ans = divide(no);
        System.out.println(ans);
        if (ans==1){
            System.out.println("is happy");

        }
        else{
            System.out.println("not happy");
        }
        sc.close();
    }
    
}
