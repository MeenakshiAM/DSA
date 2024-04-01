public class Sorted_rotatedArray {
    public static void main(String[] args) {
        
    }
    static int minNumber(int arr[], int low, int end){
        // Your code here
        int high=end;
        while(low < high){
          int mid = low + (high - low)/2;
          if(mid<high && arr[mid] > arr[mid + 1]){
            return arr[mid + 1];
          }
          else if( mid>low && arr[mid] < arr[mid - 1]){
            return arr[mid];
          }
          else if( arr[mid] < arr[high]){
            high = mid;
          }
          else {
            low = mid + 1;
          }
        }
        return arr[high];
    }
}
