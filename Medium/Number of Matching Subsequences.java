class Solution {
  public int numMatchingSubseq(String s, String[] words) {
    int count = 0;
    for (String word : words) {
      if (isSubsequence(s, word)) {
        count++;
      }
    }
    return count;
  }

  private boolean isSubsequence(String s, String word) {
    int prevIdx = 0;
    for (char c : word.toCharArray()) {
      int idx = s.indexOf(c, prevIdx);
      if (idx == -1) {
        return false;
      }
      prevIdx = idx + 1;
    }
    return true;
  }
}
