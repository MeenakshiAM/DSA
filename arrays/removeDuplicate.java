package arrays;
class removeDuplicate {
    public static void main(String[] args) {
        
    }
    int remove_duplicate(int arr[],int N){
        // code here
        int i = 0;// pointer 1 which tracks the indices
        for(int j = 1; j < N; j++){
            if(arr[i] != arr[j]){
                arr[i+1] = arr[j];
                i++;
            }
        }
        return i+1;
    }
}
