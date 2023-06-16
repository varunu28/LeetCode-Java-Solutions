class Solution {
    
    private static final long MOD = 1000_000_007;
    
    public int numOfWays(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][i] = 1; 
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return (int) ((dfs(list, dp) - 1) % MOD);
    }
    
    private long dfs(List<Integer> nums, long[][] dp) {
        int n = nums.size();
        if (n < 3) {
            return 1;
        }
        List<Integer> leftNodes = new ArrayList<>();
        List<Integer> rightNodes = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (nums.get(i) < nums.get(0)) {
                leftNodes.add(nums.get(i));
            } else {
                rightNodes.add(nums.get(i));
            }
        }
        long leftCount = dfs(leftNodes, dp) % MOD;
        long rightCount = dfs(rightNodes, dp) % MOD;
        return (((leftCount * rightCount) % MOD) * dp[n - 1][leftNodes.size()]) % MOD;
    }
}
