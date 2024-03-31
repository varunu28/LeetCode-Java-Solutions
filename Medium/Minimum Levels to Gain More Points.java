class Solution {
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        int totalScore = 0;
        for (int i = n - 1; i >= 0; i--) {
            totalScore += possible[i] == 1 ? 1 : -1;
        }
        int score = 0;
        for (int i = 0; i < n - 1; i++) {
            score += possible[i] == 1 ? 1 : -1;
            if (score > totalScore - score) {
                return i + 1;
            }
        }
        return -1;
    }
}
