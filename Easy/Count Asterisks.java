class Solution {
  public int countAsterisks(String s) {
    int asteriskCount = 0;
    int barCount = 0;
    for (char c : s.toCharArray()) {
      if (c == '|') {
        barCount++;
      } else if (c == '*') {
        if (barCount % 2 == 0) {
          asteriskCount++;
        }
      }
    }
    return asteriskCount;
  }
}
