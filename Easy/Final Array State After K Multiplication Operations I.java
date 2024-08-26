class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] o) -> o[0])
            .thenComparingInt(o -> o[1]));
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{nums[i], i});
        }
        while (k-- > 0) {
            int[] removed = pq.remove();
            int value = removed[0];
            int index = removed[1];
            int newValue = value * multiplier;
            pq.add(new int[]{newValue, index});
        }
        int[] result = new int[n];
        while (!pq.isEmpty()) {
            int[] removed = pq.remove();
            int value = removed[0];
            int index = removed[1];
            result[index] = value;
        }
        return result;
    }
}
