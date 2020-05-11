class Solution {
  public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    Map<Integer, List<Integer>> organization = new HashMap<>();
    for (int i = 0; i < manager.length; i++) {
      if (manager[i] != -1) {
        organization.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i);
      }
    }
    int totalTime = 0;
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{headID, 0});
    while (!queue.isEmpty()) {
      int[] removed = queue.remove();
      int id = removed[0]; 
      int time = removed[1]; 
      totalTime = Math.max(totalTime, time);
      for (int associate : organization.getOrDefault(id, new ArrayList<>())) {
        queue.add(new int[]{associate, time + informTime[id]});
      }
    }
    return totalTime;
  }
}
