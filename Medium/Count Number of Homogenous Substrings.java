class Solution {

    private static final int MOD = 1_000_000_007;

    public int countHomogenous(String s) {
        int result = 0;
        int streak = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i) == s.charAt(i - 1)) {
                streak++;
            } else {
                streak = 1;
            }
            result = (result + streak) % MOD;
        }
        return result;
    }
}
