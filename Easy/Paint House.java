class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        
        for (int i=1; i<costs.length; i++) {
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i-1][1], costs[i-1][0]);
        }
        
        int idx = costs.length - 1;
        int minCost = costs[idx][0];
        
        return Math.min(costs[idx][0], Math.min(costs[idx][1], costs[idx][2]));
    }
}
