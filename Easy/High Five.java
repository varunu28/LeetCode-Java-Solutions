class Solution {
  public int[][] highFive(int[][] items) {
    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    for (int[] item : items) {
      int id = item[0];
      int score = item[1];
      map.computeIfAbsent(id, k -> new PriorityQueue<>((a, b) -> b - a)).add(score);
    }
    int[][] result = new int[map.size()][2];
    int idx = 0;
    for (Integer id : map.keySet()) {
      PriorityQueue<Integer> scoresInOrder = map.get(id);
      int totalScore = 0;
      int count = Math.min(5, scoresInOrder.size());
      for (int i = 0; i < 5 && !scoresInOrder.isEmpty(); i++) {
        totalScore += scoresInOrder.poll();
      }
      result[idx++] = new int[]{id, totalScore / count};
    }
    Arrays.sort(result, (a, b) -> a[0] - b[0]);
    return result;
  }
}
