
import java.util.*;
class CombinationSum2{
    public static void main(String[] args) {
        
    }
}
class Solution {
    public List<List<Integer>> CombinationSum2(int[] arr, int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr); 
        backtrack(result, new ArrayList<>(), arr, k, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] arr, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i - 1]) {
                continue; 
            }
            if (arr[i] > target) {
                break; 
            }

            current.add(arr[i]);
            backtrack(result, current, arr, target - arr[i], i + 1);
            current.remove(current.size() - 1);
        }
    }
}
