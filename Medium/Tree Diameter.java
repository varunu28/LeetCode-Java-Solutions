class Solution {
    public int treeDiameter(int[][] edges) {
        int n = edges.length;
        List<Set<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            int nodeOne = edge[0];
            int nodeTwo = edge[1];
            graph.get(nodeOne).add(nodeTwo);
            graph.get(nodeTwo).add(nodeOne);
        }
        int[] diameter = {0};
        dfs(0, visited, graph, diameter);
        return diameter[0];
    }

    private int dfs(int node, boolean[] visited, List<Set<Integer>> graph, int[] diameter) {
        int highestDistance = 0;
        int secondHighestDistance = 0;
        visited[node] = true;
        for (Integer conn : graph.get(node)) {
            int distance = 0;
            if (!visited[conn]) {
                distance = 1 + dfs(conn, visited, graph, diameter);
            }
            if (distance > highestDistance) {
                secondHighestDistance = highestDistance;
                highestDistance = distance;
            } else if (distance > secondHighestDistance) {
                secondHighestDistance = distance;
            }
        }
        diameter[0] = Math.max(diameter[0], highestDistance + secondHighestDistance);
        return highestDistance;
    }
}
