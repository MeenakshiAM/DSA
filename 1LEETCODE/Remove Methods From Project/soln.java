class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : invocations){
            adj.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[n];
        dfs(k, adj, visited);

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i< invocations.length; i++) {
            int a = invocations[i][0];
            int b = invocations[i][1];
            
            if(visited[b] && !visited[a] ) {
                for(int j = 0; j< n; j++) {
                    ans.add(j);
                }
                return ans;
            }
        }

        for(int i = 0; i< n; i++) {
            if(!visited[i]){
                ans.add(i);
            }
        }
        return ans;
        
    }
    private void dfs(int src, List<List<Integer>> adj, boolean[] visited) {
        if(visited[src]) return;

        visited[src] = true;

        List<Integer> arr = adj.get(src);

        for(int i : arr) {
            dfs(i, adj, visited);
        }
    }


}
