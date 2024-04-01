public class bitonicPoint {
    public static void main(String[] args) {
        
    }
    static int findMaximum(int[] arr, int n) {
        // code here
        int start=0;
        int end=n-1;
        while (start<end){
            int mid= start + (end - start)/2;
            if(arr[mid] < arr[mid + 1]){
               start=mid+1 ;
            }
            else{
                end=mid;
            }
        }
        return arr[end];
    }
}
