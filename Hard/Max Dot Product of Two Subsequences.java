class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int maxOne = Integer.MIN_VALUE;
        int maxTwo = Integer.MIN_VALUE;
        int minOne = Integer.MAX_VALUE;
        int minTwo = Integer.MAX_VALUE;
        for (int num : nums1) {
            maxOne = Math.max(maxOne, num);
            minOne = Math.min(minOne, num);
        }
        for (int num : nums2) {
            maxTwo = Math.max(maxTwo, num);
            minTwo = Math.min(minTwo, num);
        }
        if (maxOne < 0 && minTwo > 0) {
            return maxOne * minTwo;
        }
        if (minOne > 0 && maxTwo < 0) {
            return minOne * maxTwo;
        }
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                int curr = nums1[i] * nums2[j] + dp[i + 1][j + 1];
                dp[i][j] = Math.max(curr, Math.max(dp[i + 1][j], dp[i][j + 1]));
            }
        }
        return dp[0][0];
    }
}
