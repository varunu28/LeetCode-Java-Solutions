class Solution {
  public boolean checkRecord(String s) {
    int absentCount = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == 'A') {
        absentCount++;
      } else if (c == 'L') {
        if (i > 1 && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L') {
          return false;
        }
      }
    }
    return absentCount < 2;
  }
}
