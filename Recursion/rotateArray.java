package Recursion;

public class rotateArray {
    public static void main(String[] args) {
        
    }
    static void reverse(int arr[], int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    static void rotateArr(int arr[], int d, int n) {
        d = d % n; 
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    } 
}
