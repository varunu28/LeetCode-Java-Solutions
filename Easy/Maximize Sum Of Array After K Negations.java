class Solution {
  public int largestSumAfterKNegations(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int sum = 0;
    for (int num : nums) {
      pq.add(num);
      sum += num;
    }
    while (k-- > 0) {
      sum -= pq.peek();
      sum += -1 * pq.peek();
      pq.add(-1 * pq.poll());
    }
    return sum;
  }
}
