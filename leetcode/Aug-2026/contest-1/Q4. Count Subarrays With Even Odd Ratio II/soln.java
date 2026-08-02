class Solution {

    class Fenwick {
        int[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 2];
        }

        void add(int idx, int val) {
            while (idx <= n) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int sum(int idx) {
            int s = 0;
            while (idx > 0) {
                s += bit[idx];
                idx -= idx & -idx;
            }
            return s;
        }

        int range(int l, int r) {
            return sum(r) - sum(l - 1);
        }
    }

    public long countRatioSubarrays(int[] nums, int a, int b) {

        int n = nums.length;

        int[] even = new int[n + 1];
        int[] odd = new int[n + 1];

        for (int i = 0; i < n; i++) {
            even[i + 1] = even[i];
            odd[i + 1] = odd[i];

            if ((nums[i] & 1) == 0)
                even[i + 1]++;
            else
                odd[i + 1]++;
        }

        long[] val = new long[n + 1];

        for (int i = 0; i <= n; i++)
            val[i] = 1L * even[i] * b - 1L * odd[i] * a;

        // coordinate compression
        long[] sorted = val.clone();
        Arrays.sort(sorted);

        Map<Long, Integer> map = new HashMap<>();

        int id = 1;
        for (long x : sorted) {
            if (!map.containsKey(x))
                map.put(x, id++);
        }

        Fenwick ft = new Fenwick(id + 2);

        List<List<Integer>> groups = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            groups.add(new ArrayList<>());

        for (int i = 0; i <= n; i++)
            groups.get(odd[i]).add(i);

        long ans = 0;

        int prevOdd = -1;

        for (int i = 0; i <= n; i++) {

            while (prevOdd + 1 < odd[i]) {
                prevOdd++;

                for (int idx : groups.get(prevOdd)) {
                    ft.add(map.get(val[idx]), 1);
                }
            }

            int pos = map.get(val[i]);

            ans += ft.range(pos, id + 1);
        }

        return ans;
    }
}
