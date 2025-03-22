class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int nodeOne = edge[0];
            int nodeTwo = edge[1];
            graph.computeIfAbsent(nodeOne, k -> new HashSet<>()).add(nodeTwo);
            graph.computeIfAbsent(nodeTwo, k -> new HashSet<>()).add(nodeOne);
        }
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (visited.add(i)) {
                int[] componentInfo = new int[2];
                dfs(i, graph, visited, componentInfo);
                if (componentInfo[0] * (componentInfo[0] - 1) == componentInfo[1]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(
        int node, 
        Map<Integer, Set<Integer>> graph, 
        Set<Integer> visited, 
        int[] componentInfo) {
        componentInfo[0]++;
        Set<Integer> connections = graph.getOrDefault(node, new HashSet<>());
        componentInfo[1] += connections.size();
        for (Integer conn : connections) {
            if (visited.add(conn)) {
                dfs(conn, graph, visited, componentInfo);
            }
        }
    }
}
