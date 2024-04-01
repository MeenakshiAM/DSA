import java.util.ArrayList;

class occurence{
    public static void main(String[] args) {
        
    }
     ArrayList<Integer> find(int arr[], int n, int x)
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(search (arr, x, n, true));
        ans.add(search (arr, x, n, false));
        return ans;
    }
    int search (int arr[], int key, int n, boolean startIndex){
        int start = 0;
        int ans= -1;
        int end= n-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > key){
                end = mid - 1;
            }
            else if(arr[mid] < key){
                start = mid + 1;
            }
            else{
                ans= mid;
                // this could be our potential ans
                if(startIndex == true){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}
