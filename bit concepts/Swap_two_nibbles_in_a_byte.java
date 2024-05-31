package bit concepts;

public class Swap_two_nibbles_in_a_byte {
    public static void main(String[] args) {
        
    }
    
}
class Solution {
    static int swapNibbles(int n) {
        // code here
        int rn =n & (0b11110000);
        int ln =n &(0b00001111);
        
        rn= rn>>4;
        ln =ln<<4;
        
        return rn|ln;
    }
}
