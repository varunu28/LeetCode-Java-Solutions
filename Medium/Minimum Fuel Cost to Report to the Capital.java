class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] road : roads) {
            graph.computeIfAbsent(road[0], k -> new ArrayList<>()).add(road[1]);
            graph.computeIfAbsent(road[1], k -> new ArrayList<>()).add(road[0]);
        }
        long[] fuel = {0l};
        dfs(0, -1, graph, seats, fuel);
        return fuel[0];
    }
    
    private long dfs(int node, int parent, Map<Integer, List<Integer>> graph, int seats, long[] fuel) {
        int representativeCount = 1;
        if (!graph.containsKey(node)) {
            return representativeCount;
        }
        for (int child : graph.get(node)) {
            if (child != parent) {
                representativeCount += dfs(child, node, graph, seats, fuel);
            }
        }
        if (node != 0) {
            fuel[0] += Math.ceil((double) representativeCount / seats); 
        }
        return representativeCount;
    }
}
