/**
 * rightLeftIndex
 */
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
class Solution {
    
    public pair indexes(long v[], long x)
    {
        // Your code goes here
        int start= startIndex(v, x );
        int end =endIndex( v,  x );
        return new pair(start, end);
        
    }
    static int startIndex(long arr[], long key ){
        int start=0;
        int end = arr.length-1;
        int ans = -1;
        while(start <= end){
            int mid = start +(end - start)/2;
            if(arr[mid] > key){
                end = mid - 1;
            }
            else if(arr[mid] < key){
                start = mid + 1;
            }
            else{
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
    static int endIndex(long arr[], long key){
        int start=0;
        int end = arr.length-1;
        int ans = -1;
        while(start <= end){
            int mid = start +(end - start)/2;
            if(arr[mid] > key){
                end = mid - 1;
            }
            else if(arr[mid] < key){
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
 public class rightLeftIndex {

    public static void main(String[] args) {
        
    }
    
}