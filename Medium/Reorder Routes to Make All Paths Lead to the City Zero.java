class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> graph = new HashMap<>();
        for (int[] conn : connections) {
            graph.computeIfAbsent(conn[0], k -> new ArrayList<>()).add(List.of(conn[1], 1));
            graph.computeIfAbsent(conn[1], k -> new ArrayList<>()).add(List.of(conn[0], 0));
        }
        int[] count = {0};
        bfs(0, n, graph, count);
        return count[0];
    }
    
    private void bfs(int node, int n, Map<Integer, List<List<Integer>>> graph, int[] count) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        visited[node] = true;
        queue.add(node);
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            for (List<Integer> conn : graph.getOrDefault(removed, new ArrayList<>())) {
                int neighbor = conn.get(0);
                int direction = conn.get(1);
                if (!visited[neighbor]) {
                    count[0] += direction;
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
