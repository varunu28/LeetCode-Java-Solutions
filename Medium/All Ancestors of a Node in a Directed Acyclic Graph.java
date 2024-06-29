class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Set<Integer>> ancestors = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ancestors.computeIfAbsent(node, k -> new HashSet<>());
            for (int dependents : graph.getOrDefault(node, Collections.emptyList())) {
                ancestors.computeIfAbsent(dependents, k -> new HashSet<>()).add(node);
                ancestors.get(dependents).addAll(ancestors.get(node));
                indegree[dependents]--;
                if (indegree[dependents] == 0) {
                    queue.offer(dependents);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> currNodeAncestors = new ArrayList<>(ancestors.getOrDefault(i, Collections.emptySet()));
            currNodeAncestors.sort(Comparator.naturalOrder());
            result.add(currNodeAncestors);
        }
        return result;
    }
}
