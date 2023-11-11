class Graph {

    private final Map<Integer, List<Connection>> graph;

    public Graph(int n, int[][] edges) {
        this.graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new Connection(edge[1], edge[2]));
        }
    }

    public void addEdge(int[] edge) {
        graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new Connection(edge[1], edge[2]));
    }

    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.add(new int[]{node1, 0});
        Set<Integer> seen = new HashSet<>();
        while (!queue.isEmpty()) {
            int[] removed = queue.remove();
            int node = removed[0];
            if (node == node2) {
                return removed[1];
            }
            if (graph.containsKey(node) && seen.add(node)) {
                for (Connection connection : graph.getOrDefault(removed[0], new ArrayList<>())) {
                    queue.add(new int[]{connection.node, removed[1] + connection.cost});
                }
            }
        }
        return -1;
    }

    private record Connection(int node, int cost) { }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
