class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (List<Integer> sequence : sequences) {
            for (Integer num : sequence) {
                indegree.putIfAbsent(num, 0);
            }
            for (int i = 1; i < sequence.size(); i++) {
                int current = sequence.get(i);
                int dependency = sequence.get(i - 1);
                adjacencyList.computeIfAbsent(dependency, _ -> new ArrayList<>())
                    .add(current);
                indegree.put(current, indegree.getOrDefault(current, 0) + 1);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Integer node : indegree.keySet()) {
            if (indegree.get(node) == 0) {
                queue.add(node);
            }
        }
        if (queue.isEmpty()) {
            return false;
        }
        int idx = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 1) {
                return false;
            }
            int removed = queue.remove();
            if (removed != nums[idx]) {
                return false;
            }
            idx++;
            for (Integer conn : adjacencyList.getOrDefault(removed, new ArrayList<>())) {
                indegree.put(conn, indegree.get(conn) - 1);
                if (indegree.get(conn) == 0) {
                    queue.add(conn);
                }
            }
        }
        return idx == nums.length;
    }
}
