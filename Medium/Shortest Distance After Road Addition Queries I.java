class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            graph.computeIfAbsent(i, k -> new HashSet<>()).add(i + 1);
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            graph.computeIfAbsent(query[0], k -> new HashSet<>()).add(query[1]);
            result[i] = findDistance(graph, n - 1);
        }
        return result;
    }

    private int findDistance(Map<Integer, Set<Integer>> graph, int target) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer node = queue.poll();
                if (node == target) {
                    return distance;
                }
                for (Integer neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(node);
                    }
                }
            }
            distance++;
        }
        return -1;
    }
}
