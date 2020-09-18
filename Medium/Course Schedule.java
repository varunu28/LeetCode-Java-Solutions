class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    int[] indegree = new int[numCourses];
    for (int[] prerequisite : prerequisites) {
      map.computeIfAbsent(prerequisite[1], k -> new HashSet<>()).add(prerequisite[0]);
      indegree[prerequisite[0]]++;
    }
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> taken = new HashSet<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
        taken.add(i);
      }
    }
    while (!queue.isEmpty()) {
      int removed = queue.remove();
      for (Integer dependentCourse : map.getOrDefault(removed, new HashSet<>())) {
        indegree[dependentCourse]--;
        if (indegree[dependentCourse] == 0) {
          taken.add(dependentCourse);
          queue.add(dependentCourse);
        }
      }
    }
    return taken.size() == numCourses;
  }
}
