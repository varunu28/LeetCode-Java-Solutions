class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] conn : connections) {
            graph.computeIfAbsent(conn[0], k -> new HashSet<>()).add(conn[1]);
            graph.computeIfAbsent(conn[1], k -> new HashSet<>()).add(conn[0]);
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(graph, i, visited);
                count++;
            }
        }
        return count - 1;
    }
    
    private void bfs(Map<Integer, Set<Integer>> graph, int start, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            for (Integer node : graph.getOrDefault(removed, new HashSet<>())) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
    }
}
