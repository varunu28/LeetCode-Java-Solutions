class Solution {
  public int getKth(int lo, int hi, int k) {
    Map<Integer, Integer> cache = new HashMap<>();
    cache.put(1, 0);
    PriorityQueue<Integer> pq = new PriorityQueue<>(
        Comparator.comparingInt((Integer o) -> cache.get(o)).thenComparingInt(o -> o));
    for (int i = lo; i <= hi; i++) {
      calculateSteps(cache, i);
      pq.add(i);
    }
    while (!pq.isEmpty() && k-- > 1) {
      pq.poll();
    }
    return pq.peek();
  }

  private int calculateSteps(Map<Integer, Integer> cache, int num) {
    if (num == 1) {
      return 0;
    }
    if (cache.containsKey(num)) {
      return cache.get(num);
    }
    int numOfSteps = 1 + calculateSteps(cache, (num % 2 == 0 ? num / 2 : num * 3 + 1));
    cache.put(num, numOfSteps);
    return cache.get(num);
  }
}
