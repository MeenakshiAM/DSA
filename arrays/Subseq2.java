import java.util.ArrayList;
import java.util.List;

public class Subseq2 {
   static void generate(int[] arr, int index, List<Integer> curr, List<List<Integer>> result) {
    if (index == arr.length) {
        if (!curr.isEmpty()) result.add(new ArrayList<>(curr));
        return;
    }
    // Include
    curr.add(arr[index]);
    generate(arr, index + 1, curr, result);
    curr.remove(curr.size() - 1);

    // Exclude
    generate(arr, index + 1, curr, result);
}
static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}

static int lcm(int a, int b) {
    return (a * b) / gcd(a, b);
}

static int getLCM(List<Integer> list) {
    int result = list.get(0);
    for (int i = 1; i < list.size(); i++) {
        result = lcm(result, list.get(i));
    }
    return result;
}
public static int countSubsequencesLCMGreaterThanK(int[] arr, int k) {
    List<List<Integer>> subsequences = new ArrayList<>();
    generate(arr, 0, new ArrayList<>(), subsequences);

    int count = 0;
    for (List<Integer> sub : subsequences) {
        if (getLCM(sub) >= k) count++;
    }
    return count;
}
 
public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4};
int k = 4;
System.out.println(countSubsequencesLCMGreaterThanK(arr, k));

}
}
