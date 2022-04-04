class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> prerequisiteToCourseDependency = new HashMap<>();
    int[] prerequisiteCount = new int[numCourses];
    for (int[] prerequisite : prerequisites) {
      prerequisiteToCourseDependency.computeIfAbsent(prerequisite[1], k -> new ArrayList<>())
        .add(prerequisite[0]);
      prerequisiteCount[prerequisite[0]]++;
    }
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (prerequisiteCount[i] == 0) {
        queue.add(i);
      }
    }
    int[] courseOrder = new int[numCourses];
    int courseOrderIdx = 0;
    while (!queue.isEmpty()) {
      int course = queue.remove();
      courseOrder[courseOrderIdx++] = course;
      for (Integer dependentCourse : prerequisiteToCourseDependency.getOrDefault(course, new ArrayList<>())) {
        prerequisiteCount[dependentCourse]--;
        if (prerequisiteCount[dependentCourse] == 0) {
          queue.add(dependentCourse);
        }
      }
    }
    return courseOrderIdx == numCourses ? courseOrder : new int[]{};
  }
}
