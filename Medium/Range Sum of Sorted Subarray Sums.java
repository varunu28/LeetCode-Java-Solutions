class Solution {
    private static final int MOD = 1000_000_007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{nums[i], i + 1});
        }
        int sum = 0;
        for (int i = 1; i <= right; i++) {
            int[] removed = pq.poll();
            if (i >= left) {
                sum = (sum + removed[0]) % MOD;
            }
            if (removed[1] < n) {
                removed[0] = removed[0] + nums[removed[1]];
                removed[1]++;
                pq.add(removed);
            }
        }
        return sum;
    }
}
