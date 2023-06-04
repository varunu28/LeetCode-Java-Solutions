class Solution {
    public int findCircleNum(int[][] isConnected) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    graph.computeIfAbsent(i, k -> new HashSet<>()).add(j);
                    graph.computeIfAbsent(j, k -> new HashSet<>()).add(i);
                }
            }
        }
        Set<Integer> visited = new HashSet<>();
        int provinces = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                traverse(graph, i, visited);
                provinces++;
            }
        }
        return provinces;
    }
    
    private void traverse(Map<Integer, Set<Integer>> graph, int city, Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(city);
        visited.add(city);
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            for (Integer conn : graph.getOrDefault(removed, new HashSet<>())) {
                if (!visited.contains(conn)) {
                    queue.add(conn);
                    visited.add(conn);
                }
            }
        }
    }
}
