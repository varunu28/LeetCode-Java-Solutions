class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] leftIncreasingLength = new int[n];
        int[] rightDecreasingLength = new int[n];
        Arrays.fill(leftIncreasingLength, 1);
        Arrays.fill(rightDecreasingLength, 1);
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    leftIncreasingLength[i] = Math.max(leftIncreasingLength[i], leftIncreasingLength[j] + 1);
                }
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    rightDecreasingLength[i] = Math.max(rightDecreasingLength[i], rightDecreasingLength[j] + 1);
                }
            }
        }
        int minRemovals = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (leftIncreasingLength[i] > 1 && rightDecreasingLength[i] > 1) {
                minRemovals = Math.min(minRemovals, n - leftIncreasingLength[i] - rightDecreasingLength[i] + 1);
            }
        }
        return minRemovals;
    }
}
