class KthLargest {

  private PriorityQueue<Integer> pq;
  private int k;
  public KthLargest(int k, int[] nums) {
    this.k = k;
    this.pq = new PriorityQueue<>();
    for (int num : nums) {
      pq.add(num);
      if (pq.size() > k) {
        pq.poll();
      }
    }
  }

  public int add(int val) {
    pq.add(val);
    if (pq.size() > k) {
      pq.poll();
    }
    return pq.peek();
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
