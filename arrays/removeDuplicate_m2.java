package arrays;
import java.util.*;

public class removeDuplicate_m2 {
    public static void main(String[] args) {
        
    }
}

class Solution {
    int remove_duplicate(int A[],int N){
        // code here
       ArrayList<Integer> myList = new ArrayList<>();
        int i = 0;
        while (i < N) {
            myList.add(A[i]);
            int current = A[i];
            while (i < N && A[i] == current) {
                i++;
            }
        }
        for (int j = 0; j < myList.size(); j++) {
            A[j] = myList.get(j);
        }
        return myList.size();
    }
}