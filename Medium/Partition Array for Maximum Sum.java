class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        Integer[] dp = new Integer[arr.length];
        return maxSum(arr, k, dp, 0);
    }

    private int maxSum(int[] arr, int k, Integer[] dp, int start) {
        int n = arr.length;
        if (start >= n) {
            return 0;
        }
        if (dp[start] != null) {
            return dp[start];
        }
        int currMax = 0;
        int result = 0;
        int end = Math.min(n, start + k);
        for (int i = start; i < end; i++) {
            currMax = Math.max(currMax, arr[i]);
            result = Math.max(result, 
                currMax * (i - start + 1) + maxSum(arr, k, dp, i + 1));
        }
        return dp[start] = result;
    }
}
