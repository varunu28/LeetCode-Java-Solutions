class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Integer[] dp = new Integer[s.length() + 1];
        return helper(0, s, Arrays.stream(dictionary).collect(Collectors.toSet()), dp);
    }

    private int helper(int idx, String s, Set<String> set, Integer[] dp) {
        if (idx == s.length()) {
            return 0;
        }
        if (dp[idx] != null) {
            return dp[idx];
        }
        int result = Integer.MAX_VALUE;
        for (int i = idx; i < s.length(); i++) {
            String sub = s.substring(idx, i + 1);
            if (set.contains(sub)) {
                result = Math.min(result, helper(i + 1, s, set, dp));
            } else {
                result = Math.min(result, i - idx + 1 + helper(i + 1, s, set, dp));
            }
        }
        return dp[idx] = result;
    }
}
