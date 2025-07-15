public class Lcm {
    public static int LCM (int[] arr){
        int prod = 1;
        for(int i : arr){
            prod *= i;
        }
        int ans =(prod)%(gcd(arr));
        return ans;
    }
    public static int gcd (int[] arr){
        if(b == 0) return a;
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,8};
        int ans = LCM(arr);
        System.out.println(ans);
    }
}
