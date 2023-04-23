class Solution {
    
    private static final int MOD = 1000_000_007;
    
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int[] dp = new int[n + 1];
        return dfs(dp, 0, s, k);
    }
    
    private int dfs(int[] dp, int start, String s, int k) {
        if (dp[start] != 0) {
            return dp[start];
        }
        if (start == s.length()) {
            return 1;
        }
        if (s.charAt(start) == '0') {
            return 0;
        }
        int count = 0;
        for (int end = start; end < s.length(); end++) {
            String currNum = s.substring(start, end + 1);
            if (Long.parseLong(currNum) > k) {
                break;
            }
            count = (count + dfs(dp, end + 1, s, k)) % MOD;
        }
        return dp[start] = count;
    }
}
