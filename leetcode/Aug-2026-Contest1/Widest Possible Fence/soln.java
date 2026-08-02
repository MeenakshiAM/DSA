class Solution {
    public int maximumWidth(int[] A) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> res = new HashMap<>();

        for (int x : A) {
            count.put(x, count.getOrDefault(x, 0) + 1);
            res.put(x, res.getOrDefault(x, 0) + 1);
        }

        for (int a : count.keySet()) {
            for (int b : count.keySet()) {
                if (a < b) {
                    res.put(a + b, res.getOrDefault(a + b, 0) + Math.min(count.get(a), count.get(b)));
                }
                if (a == b) {
                    res.put(a + b, res.getOrDefault(a + b, 0) + count.get(a) / 2);
                }
            }
        }

        int maxVal = 0;
        for (int v : res.values()) {
            maxVal = Math.max(maxVal, v);
        }

        return maxVal;
    }
}
