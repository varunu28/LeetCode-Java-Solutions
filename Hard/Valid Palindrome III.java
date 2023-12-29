class Solution {
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        Integer[][] dp = new Integer[n][n];
        return isValidPalindrome(s, 0, n - 1, dp) <= k;
    }

    private int isValidPalindrome(String s, int left, int right, Integer[][] dp) {
        if (left == right) {
            return 0;
        }
        if (left == right - 1) {
            return s.charAt(left) != s.charAt(right) ? 1 : 0;
        }
        if (dp[left][right] != null) {
            return dp[left][right];
        }
        if (s.charAt(left) == s.charAt(right)) {
            return isValidPalindrome(s, left + 1, right - 1, dp); // move both pointers
        }
        return dp[left][right] = 1 + Math.min(
            isValidPalindrome(s, left + 1, right, dp), // move only left pointer
            isValidPalindrome(s, left, right - 1, dp) // move only right pointer
        );
    }
}
