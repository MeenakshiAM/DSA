package Strings;

public class SumSubstrings {
    public static void main(String[] args) {
        
    }
}

class Solution
{
    //Function to find sum of all possible substrings of the given string.
    public static long sumSubstrings(String s)
    {
    //Your code here
    long ans = 0;
        long prev = 0, current = 0, sum = 0;
        long mod = (long) (Math.pow(10, 9) + 7);
        
        for (int i = 0; i < s.length(); i++) {
            current = (s.charAt(i) - '0') * (i + 1) + prev * 10;
            current %= mod;
            ans += current;
            ans %= mod;
            prev = current;
        }
        return ans;
    }
}