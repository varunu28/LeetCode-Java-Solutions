class Solution {
  public int lengthOfLastWord(String s) {
    int count = 0;
    int idx = s.length() - 1;
    while (idx >= 0 && s.charAt(idx) == ' ') {
      idx--;
    }
    while (idx >= 0 && s.charAt(idx) != ' ') {
      idx--;
      count++;
    }
    return count;
  }
}
