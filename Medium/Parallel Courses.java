class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];
        for (int[] relation : relations) {
            int course = relation[0];
            int dependency = relation[1];
            indegree[course - 1]++;
            graph.computeIfAbsent(dependency, k -> new HashSet<>()).add(course);
        }
        Queue<Integer> queue = new LinkedList<>();
        int numOfSemesters = 0;
        int coursesTaken = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i + 1);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int removed = queue.remove();
                coursesTaken++;
                for (Integer dependent : graph.getOrDefault(removed, new HashSet<>())) {
                    indegree[dependent - 1]--;
                    if (indegree[dependent - 1] == 0) {
                        queue.add(dependent);
                    }
                }
            }
            numOfSemesters++;
        }
        return coursesTaken == n ? numOfSemesters : -1;
    }
}
