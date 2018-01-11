class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        return climbStairs(memo, 0, n);
    }
    
    public int climbStairs(int[] memo, int i, int n) {
        if (i > n) return 0;
        if (i == n) return 1;
        
        if (memo[i] > 0) return memo[i];
        
        memo[i] = climbStairs(memo, i+1, n) + climbStairs(memo, i+2, n);
        
        return memo[i];
    }
}
