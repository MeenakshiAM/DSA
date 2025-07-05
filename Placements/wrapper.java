package Placements;

import java.util.ArrayList;

public class wrapper {
    public ArrayList<Integer>  Amount (int[] arr, int k){
        //sliding window;
        ArrayList<Integer> ans = new ArrayList<>();
        int start =0;
        int total =0;
       
        
        for (int end =0; end<arr.length; end++){
            ans.add(arr[end]);
             total+= arr[0];
            if (total == k ){
                return ans;
            }
            else if(total<k){
                ans.add(arr[end]);
            }
            else{
                ans.remove(arr[start]);
                start++;
            }
        }
        return ans;
    }
}
