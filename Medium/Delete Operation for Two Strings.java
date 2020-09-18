class Solution {
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0) {
                    memo[i][j] = j;
                }
                else if (j == 0) {
                    memo[i][j] = i;
                }
                else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    memo[i][j] = memo[i - 1][j - 1];
                }
                else {
                    memo[i][j] = Math.min(Math.min(memo[i - 1][j - 1] + 2, memo[i - 1][j] + 1), 
                                          memo[i][j - 1] + 1);
                }
            }
        }
        
        return memo[word1.length()][word2.length()];
    }
}

