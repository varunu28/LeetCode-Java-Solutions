class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int coins = 0; coins <= k; coins++) {
                int currSum = 0;
                for (int currCoins = 0; 
                     currCoins <= Math.min((int) piles.get(i - 1).size(), coins); 
                     currCoins++) {
                    if (currCoins > 0) {
                        currSum += piles.get(i - 1).get(currCoins - 1);
                    }
                    dp[i][coins] = Math.max(dp[i][coins], dp[i - 1][coins - currCoins] + currSum);
                }
            }
        }
        return dp[n][k];
    }
}
