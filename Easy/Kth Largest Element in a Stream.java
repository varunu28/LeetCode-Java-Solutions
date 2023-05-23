class KthLargest {
    
    private final PriorityQueue<Integer> pq;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>((a, b) -> a - b);
        for (int num : nums) {
            pq.add(num);
            checkLength();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        checkLength();
        return pq.peek();
    }
    
    private void checkLength() {
        if (pq.size() > k) {
            pq.poll();
        }
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
