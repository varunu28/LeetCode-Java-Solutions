class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        Set<Integer> visited = new HashSet<>();
        visited.add(source);
        while (!queue.isEmpty()) {
            Integer removed = queue.remove();
            if (removed == destination) {
                return true;
            }
            for (Integer connection : graph.getOrDefault(removed, new ArrayList<>())) {
                if (!visited.contains(connection)) {
                    queue.add(connection);
                    visited.add(connection);
                }
            }
        }
        return false;
    }
}
