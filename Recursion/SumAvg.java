import java.util.Scanner;

public class SumAvg {
    public int sums(int[] arr, int n){
        if(n<0){
            return 0;
        }
        return arr[n]+arr[n-1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i =0 ; i<n; i++){
            arr[i] = sc.nextInt();
       }
       SumAvg obj = new SumAvg();
       int ans = obj.sums(arr, n-1) ;
       double avg = ans/n;

       System.out.println("avg =" + avg);
       System.out.println("sum = " + ans);
    }
}
