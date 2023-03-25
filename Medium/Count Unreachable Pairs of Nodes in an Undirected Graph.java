class Solution {
    public long countPairs(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        long unreachableNodeCount = (((long) n) * (n - 1)) / 2;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                long reachCount = traverseHelper(i, graph, visited);
                unreachableNodeCount -= (reachCount * (reachCount - 1)) / 2;
            }
        }
        return unreachableNodeCount;
    }

    private long traverseHelper(int node, Map<Integer, Set<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        long count = 0;
        queue.add(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            count++;
            for (Integer conn : graph.getOrDefault(removed, new HashSet<>())) {
                if (!visited[conn]) {
                    visited[conn] = true;
                    queue.add(conn);
                }
            }
        }
        return count;
    }
}
