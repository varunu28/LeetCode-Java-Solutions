class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Map<Integer, Set<Set<Integer>>> map = new HashMap<>();
        Queue<State> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            map.put(i, new HashSet<>(List.of(visited)));
            queue.add(new State(i, 0, visited));
        }
        while (!queue.isEmpty()) {
            State removed = queue.remove();
            int node = removed.node();
            int steps = removed.steps();
            Set<Integer> visited = removed.visited();
            if (visited.size() == n) {
                return steps;
            }
            for (int conn : graph[node]) {
                Set<Integer> connVisited = new HashSet<>(visited);
                connVisited.add(conn);
                if (!map.get(conn).contains(connVisited)) {
                    queue.add(new State(conn, steps + 1, connVisited));
                    map.computeIfAbsent(conn, k -> new HashSet<>()).add(connVisited);
                }
            }
        }
        return -1;
    }

    private static record State(int node, int steps, Set<Integer> visited) {}
}
