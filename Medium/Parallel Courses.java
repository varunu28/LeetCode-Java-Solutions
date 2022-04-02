class Solution {
  public int minimumSemesters(int n, int[][] relations) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] indegree = new int[n + 1];
    for (int[] relation : relations) {
      graph.computeIfAbsent(relation[0], k -> new ArrayList<>()).add(relation[1]);
      indegree[relation[1]]++;
    }
    Queue<Integer> queue = new LinkedList<>();
    int numOfSemesters = 0;
    Set<Integer> coursesTaken = new HashSet<>();
    for (int i = 1; i <= n; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }
    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        int course = queue.remove();
        coursesTaken.add(course);
        for (int dependentCourse : graph.getOrDefault(course, new ArrayList<>())) {
          indegree[dependentCourse]--;
          if (indegree[dependentCourse] <= 0 && !coursesTaken.contains(dependentCourse)) {
            queue.add(dependentCourse);
          }
        }
      }
      numOfSemesters++;
    }
    return coursesTaken.size() == n ? numOfSemesters : -1;
  }
}
