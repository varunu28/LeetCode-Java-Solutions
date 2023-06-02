class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = bombs.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int x1 = bombs[i][0];
                int y1 = bombs[i][1];
                int r = bombs[i][2];
                int x2 = bombs[j][0];
                int y2 = bombs[j][1];
                if ((long) r * r >= (long) (x1 - x2) * (x1 - x2) + (long) (y1 - y2) * (y1 - y2)) {
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dfs(i, new HashSet<>(), graph));
        }
        return result;
    }
    
    private int dfs(int curr, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
        visited.add(curr);
        int count = 1;
        for (Integer neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                count += dfs(neighbor, visited, graph);
            }
        }
        return count;
    }
}
