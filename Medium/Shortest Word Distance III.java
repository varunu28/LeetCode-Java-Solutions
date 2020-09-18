class Solution {
  public int shortestWordDistance(String[] words, String word1, String word2) {
    int idx1 = -1;
    int idx2 = -1;
    boolean sameWord = word1.equals(word2);
    int n = words.length;
    int minDiff = Integer.MAX_VALUE;
    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(word1)) {
        if (sameWord) {
          if (idx1 == -1) {
            idx1 = i;
          }
        }
        else {
          idx1 = i;
        }
      }
      if (words[i].equals(word2)) {
        if (sameWord) {
          if (idx1 != i) {
            idx2 = i;
          }
        }
        else {
          idx2 = i;
        }
      }
      if (idx1 != -1 && idx2 != -1) {
        minDiff = Math.min(minDiff, Math.abs(idx1 - idx2));
        if (sameWord) {
          idx1 = idx2;
          idx2 = -1;
        }
      }
    }
    return minDiff;
  }
}

