class Solution {
  public int minimumDeviation(int[] nums) {
    int minimumValue = Integer.MAX_VALUE;
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b.compareTo(a));
    for (int num : nums) {
      if (num % 2 != 0) {
        num *= 2;
      }
      minimumValue = Math.min(minimumValue, num);
      pq.add(num);
    }
    int result = Integer.MAX_VALUE;
    while (pq.peek() % 2 == 0) {
      int removed = pq.poll() / 2;
      minimumValue = Math.min(minimumValue, removed);
      pq.add(removed);
      result = Math.min(result, pq.peek() - minimumValue);
    }
    return result;
  }
}
