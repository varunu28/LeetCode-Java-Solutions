class Solution {
    public int minimumDeviation(int[] nums) {
        int currMinimum = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            if (num % 2 != 0) {
                num *= 2;
            }
            currMinimum = Math.min(currMinimum, num);
            pq.add(num);
        }
        int deviation = Integer.MAX_VALUE;
        while (pq.peek() % 2 == 0) {
            int removed = pq.poll() / 2;
            currMinimum = Math.min(currMinimum, removed);
            pq.add(removed);
            deviation = Math.min(deviation, pq.peek() - currMinimum);
        }
        return deviation;
    }
}
