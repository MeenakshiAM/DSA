import java.util.Arrays;

public class equalArray {
    public static void main(String[] args) {
        
    }
    public static boolean check(long A[],long B[],int N)
    {
        //Your code here
        //int flag=0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0;i<N; i++){
            if(A[i]!=B[i]){
                return false;
            }
            
    }
    return true;
}
}
