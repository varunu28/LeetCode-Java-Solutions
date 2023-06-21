class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] numWithCost = new int[n][2];
        for (int i = 0; i < n; i++) {
            numWithCost[i] = new int[]{nums[i], cost[i]};    
        }
        Arrays.sort(numWithCost, (a, b) -> a[0] - b[0]);
        long[] prefixCost = new long[n];
        prefixCost[0] = numWithCost[0][1];
        for (int i = 1; i < n; i++) {
            prefixCost[i] = numWithCost[i][1] + prefixCost[i - 1];
        }
        long totalCost = 0;
        for (int i = 1; i < n; i++) {
            totalCost += 1L * numWithCost[i][1] * (numWithCost[i][0] - numWithCost[0][0]);
        }
        long result = totalCost;  
        for (int i = 1; i < n; ++i) {
            int gap = numWithCost[i][0] - numWithCost[i - 1][0];
            totalCost += 1L * prefixCost[i - 1] * gap;
            totalCost -= 1L * (prefixCost[n - 1] - prefixCost[i - 1]) * gap;
            result = Math.min(result, totalCost);
        }
        return result;
    }
}
