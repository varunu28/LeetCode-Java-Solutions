class Solution {

    private static int[][][][] dp = new int[100][101][100][26];

    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < 26; y++) {
                        dp[i][j][x][y] = -1;
                    }
                }
            }
        }
        return solver(s.toCharArray(), 0, k, 0, s.charAt(0));
    }

    private int solver(char[] letters, int idx, int k, int currFrequency, char prevChar) {
        if (idx == letters.length) {
            return getLetterCount(currFrequency);
        }
        if (dp[idx][k][currFrequency][prevChar - 'a'] != -1) {
            return dp[idx][k][currFrequency][prevChar - 'a'];
        }
        int result = 0;
        if (letters[idx] == prevChar) {
            result = k == 0 ? 
                solver(letters, idx + 1, k, currFrequency + 1, prevChar) : 
                Math.min(
                    solver(letters, idx + 1, k , currFrequency + 1, prevChar), // don't delete
                    solver(letters, idx + 1, k - 1 , currFrequency, prevChar) // delete
                );
        } else {
            result = k == 0 ?
                getLetterCount(currFrequency) + solver(letters, idx + 1, k, 1, letters[idx]) :
                Math.min(
                    getLetterCount(currFrequency) + solver(letters, idx + 1, k, 1, letters[idx]), // don't delete
                    solver(letters, idx + 1, k - 1, currFrequency, prevChar) // delete
                );
        }
        return dp[idx][k][currFrequency][prevChar - 'a'] = result;
    }

    private static int getLetterCount(int frequency) {
        if (frequency == 0) {
            return 0;
        }
        int digits = 1;
        if (frequency > 9) {
            digits = 2;
        }
        if (frequency > 99) {
            digits = 3;
        }
        return frequency == 1 ? 1 : (digits + 1);
    }
}
