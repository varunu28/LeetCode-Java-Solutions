class Solution {
  
  private final static int MOD = (int) Math.pow(10, 9) + 7;
  
  public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
    List<int[]> pairs = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      pairs.add(new int[]{efficiency[i], speed[i]});
    }
    Collections.sort(pairs, (o1, o2) -> o2[0] - o1[0]);
    PriorityQueue<Integer> speedMinHeap = new PriorityQueue<>();
    long speedSum = 0;
    long performance = 0;
    for (int[] pair : pairs) {
      Integer currEfficiency = pair[0];
      Integer currSpeed = pair[1];
      if (speedMinHeap.size() > k - 1) {
        speedSum -= speedMinHeap.remove();
      }
      speedMinHeap.add(currSpeed);
      speedSum += currSpeed;
      performance = Math.max(performance, speedSum * currEfficiency);
    }
    return (int) (performance % MOD);
  }
}
