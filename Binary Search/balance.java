public class balance {
    public static void main(String[] args) {
        
    }
}
class Solution {
    public static String isBalanced(int a[], int n, int x) {
        int ceilIndex = ceil(a, n, x);
        int floorIndex = floor(a, n, x);

        if (floorIndex == -1 || ceilIndex == -1) {
            return "Balanced";
        } else if (Math.abs(x - a[floorIndex]) == Math.abs(a[ceilIndex] - x)) {
            return "Balanced";
        } else {
            return "Not Balanced";
        }
    }

    static int ceil(int arr[], int n, int x) {
        int start = 0;
        int end = n - 1;
        int ceilIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (x > arr[mid]) {
                start = mid + 1;
            } else {
                ceilIndex = mid;
                end = mid - 1;
            }
        }
        return ceilIndex;
    }

    static int floor(int arr[], int n, int x) {
        int start = 0;
        int end = n - 1;
        int floorIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (x > arr[mid]) {
                floorIndex = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return floorIndex;
    }
}
