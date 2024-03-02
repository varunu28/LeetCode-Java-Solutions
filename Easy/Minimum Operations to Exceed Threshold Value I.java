class Solution {
    public int minOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(map.keySet());
        int count = 0;
        while (!pq.isEmpty() && pq.peek() < k) {
            count += map.get(pq.poll());
        }
        return count;
    }
}
