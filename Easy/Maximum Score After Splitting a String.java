class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int ones = 0;
        for (int i = 0; i < n; i++) {
            ones += s.charAt(i) == '1' ? 1 : 0;
        }
        int score = 0;
        int zeros = 0;
        for (int i = 0; i < n - 1; i++) {
            ones -= s.charAt(i) == '1' ? 1 : 0;
            zeros += s.charAt(i) == '0' ? 1 : 0;
            score = Math.max(score, zeros + ones);
        }
        return score;
    }
}
