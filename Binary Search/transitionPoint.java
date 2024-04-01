/**
 * transitionPoint
 */
public class transitionPoint {

    public static void main(String[] args) {
        
    }
    int transitionPoint(int arr[], int n) {
        for (int i = 0; i < n; ++i) {
            if (arr[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}