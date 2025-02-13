class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add((long) num);
        }
        int operations = 0;
        while (pq.peek() < k) {
            long smallest = pq.poll();
            long secondSmallest = pq.poll();
            long newValue = Math.min(smallest, secondSmallest) * 2 + Math.max(smallest, secondSmallest);
            pq.add(newValue);
            operations++;
        }
        return operations;
    }
}
