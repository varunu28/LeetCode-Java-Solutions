class Solution {
    public int[] minCosts(int[] cost) {
        int n = cost.length;
        int[] result = new int[n];
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int curr = cost[i];
            minCost = Math.min(minCost, curr);
            result[i] = minCost;
        }
        return result;
    }
}
