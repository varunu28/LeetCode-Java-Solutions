class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (Integer conn : graph[i]) {
                indegree[i]++;
                map.computeIfAbsent(conn, k -> new HashSet<>()).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {    
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int removed = queue.remove();
                result.add(removed);
                for (Integer conn : map.getOrDefault(removed, new HashSet<>())) {
                    indegree[conn]--;
                    if (indegree[conn] == 0) {
                        queue.add(conn);
                    }
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}
