/*
 
 */



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int firstIndex = findFirstIndex(arr, x);
        if (firstIndex == -1) {
            return 0; // Element not found
        }

        int lastIndex = findLastIndex(arr, x);
        return lastIndex - firstIndex + 1;
    }


     static int findFirstIndex(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                result = mid;
                high = mid - 1; // Continue searching in the left half
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    static int findLastIndex(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                result = mid;
                low = mid + 1; // Continue searching in the right half
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}
