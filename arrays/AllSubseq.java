import java.util.ArrayList;
import java.util.List;

public class AllSubseq {
    public static void generate(int arr[], int index, List<Integer> curr, List<List<Integer>> ans){
            if (index == arr.length) {
                ans.add(new ArrayList<>(curr)); // Add a copy of current subsequence
                return;
            }

            // Include current element
            curr.add(arr[index]);
            generate(arr, index + 1, curr, ans);

            // Backtrack to exclude current element
            curr.remove(curr.size() - 1);
            generate(arr, index + 1, curr, ans);
    }
    
    public static List<List<Integer>> allSubsequences(int arr[]){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        generate(arr,0, res, ans);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> result = allSubsequences(arr);

        for (List<Integer> seq : result) {
            System.out.println(seq);
        }
    }
}
