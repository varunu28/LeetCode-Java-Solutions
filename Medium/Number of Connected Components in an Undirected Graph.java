class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }
        int connectedComponentCount = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                Queue<Integer> queue = new LinkedList<>();
                visited.add(i);
                queue.add(i);
                while (!queue.isEmpty()) {
                    int removed = queue.remove();
                    for (Integer neighbor : graph.getOrDefault(removed, new HashSet<>())) {
                        if (!visited.contains(neighbor)) {
                            queue.add(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
                connectedComponentCount++;
            }
        }
        return connectedComponentCount;
    }
}
