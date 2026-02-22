class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return dfs(s, p, 0, 0, memo);
    }

    private boolean dfs(String s, String p, int sIdx, int pIdx, Boolean[][] memo) {
        if (sIdx >= s.length() && pIdx >= p.length()) {
            return true;
        }
        if (pIdx >= p.length()) {
            return false;
        }
        if (memo[sIdx][pIdx] != null) {
            return memo[sIdx][pIdx];
        }
        boolean match = sIdx < s.length() && (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '.');
        if (pIdx + 1 < p.length() && p.charAt(pIdx + 1) == '*') {
            return memo[sIdx][pIdx] = (
                dfs(s, p, sIdx, pIdx + 2, memo) || // Skip the * 
                (match && dfs(s, p, sIdx + 1, pIdx, memo)) // Choose * if there was a match 
            ); 
        }
        return memo[sIdx][pIdx] = match ? dfs(s, p, sIdx + 1, pIdx + 1, memo) : false;
    }
}
