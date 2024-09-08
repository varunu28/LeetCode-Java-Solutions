class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        return recurse(0, -1, map, hasApple);
    }

    private int recurse(int node, int parent, Map<Integer, List<Integer>> graph, List<Boolean> hasApple) {
        if (!graph.containsKey(node)) {
            return 0;
        }
        int time = 0;
        for (Integer conn: graph.get(node)) {
            if (conn == parent) {
                continue;
            }
            int connTime = recurse(conn, node, graph, hasApple);
            if (connTime > 0 || hasApple.get(conn)) {
                time += connTime + 2;
            }
        }
        return time;
    }
}
