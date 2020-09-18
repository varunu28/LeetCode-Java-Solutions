class KthLargest {
  PriorityQueue<Integer> pq;
  int k;
  public KthLargest(int k, int[] nums) {
    pq = new PriorityQueue<>();
    this.k = k;
    for (int num : nums) {
      add(num);
    }
  }

  public int add(int num) {
    if (pq.size() < k) {
      pq.add(num);
    }
    else if (pq.peek() < num) {
      pq.poll();
      pq.add(num);
    }
    return pq.peek();
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
