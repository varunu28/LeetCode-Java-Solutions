class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int groupId = m;
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = groupId++;
            }
        }
        Map<Integer, List<Integer>> nodeToDependentNodes = new HashMap<>();
        Map<Integer, List<Integer>> groupToDependentGroups = new HashMap<>();
        int[] itemIndegree = new int[n];
        int[] groupIndegree = new int[groupId];
        for (int i = 0; i < beforeItems.size(); i++) {
            for (Integer prev : beforeItems.get(i)) {
                nodeToDependentNodes.computeIfAbsent(prev, k -> new ArrayList<>()).add(i);
                itemIndegree[i]++;
                if (group[i] != group[prev]) {
                    groupToDependentGroups.computeIfAbsent(group[prev], k -> new ArrayList<>()).add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }
        List<Integer> itemOrdering = topologicalSort(nodeToDependentNodes, itemIndegree);
        List<Integer> groupOrdering = topologicalSort(groupToDependentGroups, groupIndegree);
        if (itemOrdering.isEmpty() || groupOrdering.isEmpty()) {
            return new int[]{};
        }
        Map<Integer, List<Integer>> orderedGroups = new HashMap<>();
        for (Integer item : itemOrdering) {
            orderedGroups.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);
        }
        int[] result = new int[n];
        int idx = 0;
        for (Integer groupNo : groupOrdering) {
            for (Integer item : orderedGroups.getOrDefault(groupNo, new ArrayList<>())) {
                result[idx++] = item;
            }
        }
        return result;
    }
    
    private static List<Integer> topologicalSort(Map<Integer, List<Integer>> graph, int[] indegree) {
        List<Integer> visited = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            visited.add(removed);
            for (Integer conn : graph.getOrDefault(removed, new ArrayList<>())) {
                indegree[conn]--;
                if (indegree[conn] == 0) {
                    queue.add(conn);
                }
            }
        }
        return visited.size() == indegree.length ? visited : new ArrayList<>();
    }
}
