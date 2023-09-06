class Solution {
    
    private final int NOT_FOUND_VALUE = 100_000;
    
    public int minimumOperations(String num) {
        Integer[][] dp = new Integer[100][25];
        return helper(num, 0, 0, dp);
    }
    
    private int helper(String num, int idx, int mod, Integer[][] dp) {
        if (idx == num.length()) {
            if (mod == 0) {
                return 0;
            }
            return NOT_FOUND_VALUE;
        }
        if (dp[idx][mod] != null) {
            return dp[idx][mod];
        }
        int take = helper(num, idx + 1, (mod * 10 + (num.charAt(idx) - '0')) % 25, dp);
        int remove = 1 + helper(num, idx + 1, mod, dp);
        dp[idx][mod] = Math.min(take, remove);
        return dp[idx][mod];
    }
}
