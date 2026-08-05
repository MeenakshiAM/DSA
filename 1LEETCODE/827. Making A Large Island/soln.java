class Solution {
    public int largestIsland(int[][] grid) {
         int n = grid.length;
        DSU dsu = new DSU(n * n);

        // Step 1: union adjacent 1s
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int id1 = r * n + c;
                    for (int[] d : dirs) {
                        int nr = r + d[0], nc = c + d[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            int id2 = nr * n + nc;
                            dsu.union(id1, id2);
                        }
                    }
                }
            }
        }

        // Step 2: max island size without flips
        int max = 0;
        for (int i = 0; i < n * n; i++) {
            if (grid[i/n][i%n] == 1) {
                max = Math.max(max, dsu.getSize(i));
            }
        }

        // Step 3: try flipping each 0
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> seen = new HashSet<>();
                    int size = 1; // flip this cell
                    for (int[] d : dirs) {
                        int nr = r + d[0], nc = c + d[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            int root = dsu.find(nr * n + nc);
                            if (seen.add(root)) {
                                size += dsu.size[root];
                            }
                        }
                    }
                    max = Math.max(max, size);
                }
            }
        }

        return max;
    }

    class DSU {
        int[] parent, size;
        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int x, int y) {
            int root1 = find(x), root2 = find(y);
            if (root1 == root2) return;
            if (size[root1] >= size[root2]) {
                parent[root2] = root1;
                size[root1] += size[root2];
            } else {
                parent[root1] = root2;
                size[root2] += size[root1];
            }
        }
        int getSize(int x) {
            return size[find(x)];
        }
    }
}
