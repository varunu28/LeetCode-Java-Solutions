class Solution {
    Integer[] memo;
    public int tribonacci(int n) {
        memo = new Integer[n + 1];
        return helper(n);
    }

    private int helper(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        if (memo[n] != null) {
            return memo[n];
        }

        memo[n] = helper(n - 3) + helper(n - 2) + helper(n - 1);
        return memo[n];
    }
}
