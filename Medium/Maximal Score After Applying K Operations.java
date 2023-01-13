class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            pq.add(num);
        }
        long sum = 0;
        while (!pq.isEmpty() && k-- > 0) {
            int removed = pq.poll();
            sum += removed;
            pq.add((int) Math.ceil(((double) removed) / 3));
        }
        return sum;
    }
}
