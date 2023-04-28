class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                    graph.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, graph, visited);
                count++;
            }
        }
        return count;
    }
    
    private boolean isSimilar(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        return diff == 0 || diff == 2;
    }
    
    private void bfs(int node, Map<Integer, List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (!graph.containsKey(node)) {
                continue;
            }
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}
