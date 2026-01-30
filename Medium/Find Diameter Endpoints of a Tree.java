class Solution {
    public String findSpecialNodes(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], _ -> new HashSet<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], _ -> new HashSet<>()).add(edge[0]);
        }
        char[] result = new char[n];
        Arrays.fill(result, '0');
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        TraversalResutl firstTraversal = traverse(graph, distance, 0);
        int farthestNode = firstTraversal.farthestNode();
        int maxDistance = firstTraversal.maxDistance();
        populateResult(n, distance, maxDistance, result);
        Arrays.fill(distance, -1);
        distance[farthestNode] = 0;
        TraversalResutl secondTraversal = traverse(graph, distance, farthestNode);
        maxDistance = secondTraversal.maxDistance();
        populateResult(n, distance, maxDistance, result);
        return String.valueOf(result);
    }

    private void populateResult(int n, int[] distance, int maxDistance, char[] result) {
        for (int i = 0; i < n; i++) {
            if (distance[i] == maxDistance) {
                result[i] = '1';
            }
        }
    }

    public TraversalResutl traverse(Map<Integer, Set<Integer>> graph, int[] distance, int node) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        distance[node] = 0;
        int maxDistance = 0;
        int farthestNode = 0;
        while (!stack.isEmpty()) {
            int removed = stack.pop();
            for (Integer neighbor : graph.getOrDefault(removed, new HashSet<>())) {
                if (distance[neighbor] != -1) {
                    continue;
                }
                distance[neighbor] = distance[removed] + 1;
                stack.push(neighbor);
                if (distance[neighbor] > maxDistance) {
                    maxDistance = distance[neighbor];
                    farthestNode = neighbor;
                }
            }
        }
        return new TraversalResutl(farthestNode, maxDistance);
    }

    record TraversalResutl(int farthestNode, int maxDistance) {}
}
