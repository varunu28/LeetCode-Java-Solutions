class Solution {
    
    private static final int MOD = 1000_000_007;
    
    public int numWays(String[] words, String target) {
        int m = target.length();
        int k = words[0].length();
        int[][] count = new int[26][k];
        for (int i = 0; i < k; i++) {
            for (String word : words) {
                count[word.charAt(i) - 'a'][i]++;
            }
        }
        long[][] dp = new long[m + 1][k + 1];
        dp[0][0] = 1l;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < k; j++) {
                if (i < m) {
                    dp[i + 1][j + 1] += count[target.charAt(i) - 'a'][j] * dp[i][j];
                    dp[i + 1][j + 1] %= MOD;
                }
                dp[i][j + 1] += dp[i][j];
                dp[i][j + 1] %= MOD;
            }
        }
        return (int) dp[m][k];
    }
}
