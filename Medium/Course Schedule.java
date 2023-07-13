class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            indegree[course]++;
            map.computeIfAbsent(prereq, k -> new HashSet<>()).add(course);
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                visited.add(i);
            }            
        }
        while (!queue.isEmpty()) {
            int removed = queue.remove();
            for (Integer conn : map.getOrDefault(removed, new HashSet<>())) {
                indegree[conn]--;
                if (indegree[conn] == 0) {
                    queue.add(conn);
                    visited.add(conn);
                }
            }
        }
        return visited.size() == numCourses;
    }
}
