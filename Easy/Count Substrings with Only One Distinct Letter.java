class Solution {
  public int countLetters(String S) {
    int start = 0;
    int end = 0;
    Map<Character, Integer> map = new HashMap<>();
    int count = 0;
    int n = S.length();
    while (end < n) {
      char c = S.charAt(end);
      while (end < n && S.charAt(end) == c) {
        end++;
      }
      int temp = end - start;
      start = end;
      count += temp * (temp + 1) / 2;
    }
    return count;
  }
}
