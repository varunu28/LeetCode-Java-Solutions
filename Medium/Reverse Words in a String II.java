class Solution {
  public void reverseWords(char[] s) {
    reverse(s, 0, s.length - 1);
    int startIdx = 0;
    for (int i = 0; i < s.length; i++) {
      if (s[i] == ' ' || i == s.length - 1) {
        reverse(s, startIdx, (i == s.length - 1 ? i : i - 1));
        startIdx = i + 1;
      }
    }
  }
  
  private void reverse(char[] s, int startIdx, int endIdx) {
    while (startIdx < endIdx) {
      char temp = s[startIdx];
      s[startIdx] = s[endIdx];
      s[endIdx] = temp;
      startIdx++;
      endIdx--;
    }
  }
}
