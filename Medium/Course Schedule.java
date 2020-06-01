class Solution {
  Set<Integer> set = new HashSet<>();
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int[] prerequisite : prerequisites) {
      map.computeIfAbsent(prerequisite[0], k -> new HashSet<>()).add(prerequisite[1]);
    }
    for (int i = 0; i < numCourses; i++) {
      set.clear();
      dfs(map, i);
      if (set.contains(i)) {
        return false;
      }
    }
    return true;
  }
  
  private void dfs(Map<Integer, Set<Integer>> map, int num) {
    Iterator<Integer> iter = map.getOrDefault(num, new HashSet<>()).iterator();
    while (iter.hasNext()) {
      int course = iter.next();
      if (!set.contains(course)) {
        set.add(course);
        dfs(map, course);
      }
    }
  }
}
