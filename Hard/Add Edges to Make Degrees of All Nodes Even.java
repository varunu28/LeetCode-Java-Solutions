class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (List<Integer> edge : edges) {
            graph.computeIfAbsent(edge.get(0), k -> new HashSet<>()).add(edge.get(1));
            graph.computeIfAbsent(edge.get(1), k -> new HashSet<>()).add(edge.get(0));
        }
        List<Integer> nodeWithOddEdges = graph.entrySet()
            .stream()
            .filter(e -> e.getValue().size() % 2 != 0)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        if (nodeWithOddEdges.size() == 0) {
            return true;
        }
        if (nodeWithOddEdges.size() == 2) {
            Integer nodeOne = nodeWithOddEdges.get(0);
            Integer nodeTwo = nodeWithOddEdges.get(1);
            if (!hasEdge(graph, nodeOne, nodeTwo)) {
                return true;
            }
            for (int i = 1; i <= n; i++) {
                if (i == nodeOne || i == nodeTwo) {
                    continue;
                }
                if (!hasEdge(graph, i, nodeOne) && !hasEdge(graph, i, nodeTwo)) {
                    return true;
                }
            }
        }
        if (nodeWithOddEdges.size() == 4) {
            Integer nodeOne = nodeWithOddEdges.get(0);
            Integer nodeTwo = nodeWithOddEdges.get(1);
            Integer nodeThree = nodeWithOddEdges.get(2);
            Integer nodeFour = nodeWithOddEdges.get(3);
            if ((!hasEdge(graph, nodeOne, nodeTwo) && !hasEdge(graph, nodeThree, nodeFour)) || 
                (!hasEdge(graph, nodeOne, nodeThree) && !hasEdge(graph, nodeTwo, nodeFour)) || 
                (!hasEdge(graph, nodeOne, nodeFour) && !hasEdge(graph, nodeTwo, nodeThree))) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean hasEdge(Map<Integer, Set<Integer>> graph, int nodeOne, int nodeTwo) {
        return graph.getOrDefault(nodeOne, new HashSet<>()).contains(nodeTwo);
    }
}
