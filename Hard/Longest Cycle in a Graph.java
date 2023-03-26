class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int[] result = {-1};
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(i, 1);
                dfs(i, edges, map, visited, result);
            }
        }
        return result[0];
    }
    
    private void dfs(int node, int[] edges, Map<Integer, Integer> map, boolean[] visited, int[] result) {
        visited[node] = true;
        int neighbor = edges[node];
        if (neighbor != -1 && !visited[neighbor]) {
            map.put(neighbor, map.get(node) + 1);
            dfs(neighbor, edges, map, visited, result);
        } else if (neighbor != -1 && map.containsKey(neighbor)) {
            result[0] = Math.max(result[0], map.get(node) - map.get(neighbor) + 1);
        }
    }
}
