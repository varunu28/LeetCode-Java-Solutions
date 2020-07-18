class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] prereqCount = new int[numCourses];
    for (int[] prerequisite : prerequisites) {
      prereqCount[prerequisite[0]]++;
      map.computeIfAbsent(prerequisite[1], k -> new ArrayList<>()).add(prerequisite[0]);
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (prereqCount[i] == 0) {
        queue.add(i);
      }
    }
    int[] ans = new int[numCourses];
    int idx = 0;
    while (!queue.isEmpty()) {
      int removed = queue.remove();
      for (Integer dependentCourse : map.getOrDefault(removed, new ArrayList<>())) {
        prereqCount[dependentCourse]--;
        if (prereqCount[dependentCourse] == 0) {
          queue.add(dependentCourse);
        }
      }
      ans[idx++] = removed;
    }
    return idx == numCourses ? ans : new int[]{};
  }
}
