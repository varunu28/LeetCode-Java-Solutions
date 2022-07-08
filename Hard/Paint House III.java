class Solution {
  private static final int MAXIMUM_POSSIBLE_COST = 1000001;
  
  public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
    Integer[][][] dp = new Integer[m + 1][target + 1][n + 1]; // [Current House][Neighborhood Count][Previous Color]
    int result = helper(houses, cost, target, 0, 0, dp);
    return result == MAXIMUM_POSSIBLE_COST ? -1 : result;
  }
  
  public int helper(int[] houses, int[][] cost, int target, int idx, int numOfNeighbourhood, Integer[][][] dp) {
    if (idx == houses.length) {
      return numOfNeighbourhood != target ? MAXIMUM_POSSIBLE_COST : 0;
    }
    if (numOfNeighbourhood > target) {
      return MAXIMUM_POSSIBLE_COST;
    }
    int prevHouseColor = idx == 0 ? 0 : houses[idx - 1];
    if (dp[idx][numOfNeighbourhood][prevHouseColor] != null) {
      return dp[idx][numOfNeighbourhood][prevHouseColor];
    }
    int minimumCost = MAXIMUM_POSSIBLE_COST;
    if (houses[idx] != 0) {
      int currColor = houses[idx];
      int updatedNumOfNeighbourhood = currColor != prevHouseColor ? numOfNeighbourhood + 1 : numOfNeighbourhood;
      minimumCost = helper(houses, cost, target, idx + 1, updatedNumOfNeighbourhood, dp);
    } else {
      for (int currentColor = 1; currentColor <= cost[idx].length; currentColor++) {
        houses[idx] = currentColor; // Color the house with currentColor
        int updatedNumOfNeighbourhood = currentColor != prevHouseColor ? numOfNeighbourhood + 1 : numOfNeighbourhood;
        int currCost = cost[idx][currentColor - 1] + helper(houses, cost, target, idx + 1, updatedNumOfNeighbourhood, dp);
        minimumCost = Math.min(minimumCost, currCost);
        houses[idx] = 0; // Remove the currentColor for recursion
      }
    }
    return dp[idx][numOfNeighbourhood][prevHouseColor] = minimumCost;
  }
}
