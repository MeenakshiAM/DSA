import java.util.ArrayList;

public class occurence2 {
    public static void main(String[] args) {
        
    }
    public ArrayList<Integer> firstAndLast(int arr[], int n, int x){
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        int start = startindex(arr, n, x);
        int end = endindex(arr, n, x);
        
        if (start == -1 || end == -1) {
            ans.add(-1);
            return ans;
        }

        ans.add(start);
        ans.add(end);
        return ans;
    }
    static int startindex(int arr[], int n, int x){
        int start = 0;
        int end = n-1;
        int ans= -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] > x){
                end = mid - 1;
            }
            else if(arr[mid] < x){
                start = mid + 1;
            }
            else{
                ans = mid; 
                end = mid - 1; 
            }
        }  
        return ans;
    }
    static int endindex(int arr[], int n, int x){
        int start = 0;
        int end = n-1;
        int ans= -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] > x){
                end = mid - 1;
            }
            else if(arr[mid] < x){
                start = mid + 1;
            }
            else{
                ans = mid; 
                start = mid + 1; 
            }
        }  
        return ans;
    } 
}
