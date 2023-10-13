class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int stepOneCost = cost[0];
        int stepTwoCost = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int currCost = cost[i] + Math.min(stepOneCost, stepTwoCost);
            stepOneCost = stepTwoCost;
            stepTwoCost = currCost;
        }
        return Math.min(stepOneCost, stepTwoCost);
    }
}
