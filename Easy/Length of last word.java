class Solution {
  public int lengthOfLastWord(String s) {
    int idx = s.length() - 1;
    while (idx >= 0 && s.charAt(idx) == ' ') {
      idx--;
    }
    int currIdx = idx;
    while (idx >= 0 && s.charAt(idx) != ' ') {
      idx--;
    }
    return currIdx - idx;
  }
}
