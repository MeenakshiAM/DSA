class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        // the brute force approach 

        
        int n = shifts.length;
        int m = tasks.length;

        long[] prefix = new long[m];
        prefix[0] = tasks[0];

        for(int i = 1; i < m; i++) {
            prefix[i] = prefix[i-1] + tasks[i];
        }

        // remember the prefix array created is sorted 
        // so for searching we can use the binary search to find the floor of the no.;
        int[] ans = new int[n];
        long total = prefix[m - 1];

        long progress = 0; // total time spent so far

        for (int j = 0; j < n; j++) {
            progress += shifts[j];

            if (progress >= total) {
                // all tasks finished → restart
                ans[j] = 0;
                progress = 0;
            } else {
                // binary search to find how many tasks are completed
                int idx = binarySearch(prefix, progress);
                if (idx < 0) idx = -idx - 1; // insertion point
                ans[j] = m - idx;
            }
        }

        return ans;
        
       
    }

    int binarySearch(long[] prefix, long progress) {
        int lo = 0, hi = prefix.length - 1;
        int ans = prefix.length; // default: all tasks done
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (prefix[mid] > progress) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }
}
