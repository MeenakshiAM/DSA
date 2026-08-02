class Solution {
    public long maxPairStrength(int[] nums) {
        int n = nums.length;
        long strength = 0;

        for(int i = 0; i<n ; i++) {
            for(int j = i +1; j< n; j++) {
                int g = gcd(nums[i], nums[j]);
                 long res = ((long)nums[i] * (long)nums[j]) / (long)(g*g);
                strength = Math.max(strength, res);
            }
        }
        return strength;
    }
    private int gcd (int a , int b) {
        if(b == 0) return a;
            while(b != 0){
               int temp = a % b;
                a = b;
                b = temp;
                
            }
        return a;
    }
}
