class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        Queue<Integer> path = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        path.add(0);
        int steps = 0;
        while (!path.isEmpty()) {
            int size = path.size();
            while (size-- > 0) {
                int removed = path.remove();
                if (removed == n - 1) {
                    return steps;
                }
                for (Integer child : graph.get(arr[removed])) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        path.add(child);
                    }
                }
                graph.get(arr[removed]).clear();
                if (removed + 1 < n && !visited.contains(removed + 1)) {
                    visited.add(removed + 1);
                    path.add(removed + 1);
                }
                if (removed - 1 >= 0 && !visited.contains(removed - 1)) {
                    visited.add(removed - 1);
                    path.add(removed - 1);
                }
            }
            steps++;
        }
        return -1;
    }
}
