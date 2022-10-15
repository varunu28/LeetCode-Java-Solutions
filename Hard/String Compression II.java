class Solution {
  
  /**
  * First dimension : Current index
  * Second dimension : Amount of available deletions
  * Third dimension : Index of previous character
  * Fourth dimension : Consecutive count of previous character
  */
  private static int[][][][] dp = new int[100][101][100][26];
  
  public int getLengthOfOptimalCompression(String s, int k) {
    int n = s.length();
    for(int i = 0; i < n; i++) {
      for(int j = 0; j <= k; j++) {
        for(int z = 0; z < n; z++) {
          for(int l = 0; l < 26; l++) {
            dp[i][j][z][l]=-1;
          }
        }
      }
    }
    return best(s.toCharArray(), /* idx= */ 0, k, /* count= */ 0, /* prevChar= */ s.charAt(0));
  }
  
  private int best(char[] letters, int idx, int k, int count, char prevChar) {
    if (idx == letters.length) {
      return countNumberOfLetters(count);
    }
    if (dp[idx][k][count][prevChar - 'a'] != -1) {
      return dp[idx][k][count][prevChar - 'a'];
    }
    if (k == 0) {
      int result = 0;
      if (letters[idx] == prevChar) {
        result = best(letters, idx + 1, k, count + 1, prevChar);
      } else {
        result = countNumberOfLetters(count) + best(letters, idx + 1, k, 1, letters[idx]);
      }
      dp[idx][k][count][prevChar - 'a'] = result;
      return result;
    }
    int result = 0;
    if (letters[idx] == prevChar) {
      result = Math.min(
        best(letters, idx + 1, k, count + 1, prevChar), // Delete and recurse forward
        best(letters, idx + 1, k - 1, count, prevChar)); // Don't delete and recurse forward
    } else {
      result = Math.min(
        countNumberOfLetters(count) + best(letters, idx + 1, k, /* count= */ 1, /* prevChar= */ letters[idx]), // Don't delete current char and recurse forward with new count
        best(letters, idx + 1, k - 1, count, prevChar)); // Delete current character and recurse forward
    }
    dp[idx][k][count][prevChar - 'a'] = result;
    return result;
  }
  
  private static int countNumberOfLetters(int count) {
    if (count == 0) {
      return count;
    }
    int numberOfDigits = 1;
    if (count > 9) {
      numberOfDigits = 2;
    } 
    if (count > 99) {
      numberOfDigits = 3;
    }
    return count == 1 ? 1 : (numberOfDigits + 1);
  }
}
