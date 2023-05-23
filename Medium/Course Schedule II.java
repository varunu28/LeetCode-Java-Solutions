class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int[] indegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int dependency = prerequisite[1];
            map.computeIfAbsent(dependency, k -> new HashSet<>()).add(course);
            indegree[course]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[numCourses];
        int resultIdx = 0;
        Set<Integer> taken = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            result[resultIdx++] = removed;
            for (Integer dependent : map.getOrDefault(removed, new HashSet<>())) {
                indegree[dependent]--;
                if (indegree[dependent] == 0) {
                    queue.add(dependent);
                }
            }
        }
        return resultIdx == numCourses ? result : new int[0];
    }
}
