import java.util.HashSet;
import java.util.Scanner;

public class identical {
    public int identicalCount(int[] arr){
        int count = 0;
        HashSet<Integer> seen = new HashSet<>();
        for(int i : arr){
            if(seen.contains(i)){
                count++;
            }
            else{
                seen.add(i);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        identical obj = new identical();
       int ans = obj.identicalCount(arr);
       System.out.println("ans is :"+ans);
       
    }
}
