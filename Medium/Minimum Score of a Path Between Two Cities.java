class Solution {
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<List<Integer>>> graph = new HashMap<>();
        for (int[] road : roads) {
            graph.computeIfAbsent(road[0], k -> new ArrayList<>())
                .add(List.of(road[1], road[2]));
            graph.computeIfAbsent(road[1], k -> new ArrayList<>())
                .add(List.of(road[0], road[2]));
        }
        return bfs(n, graph);
    }
    
    private int bfs(int n , Map<Integer, List<List<Integer>>> graph) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        int result = Integer.MAX_VALUE;
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (List<Integer> edge : graph.getOrDefault(node, new ArrayList<>())) {
                result = Math.min(result, edge.get(1));
                if (!visited[edge.get(0)]) {
                    visited[edge.get(0)] = true;
                    queue.add(edge.get(0));
                }
            }
        }
        return result;
    }
}
