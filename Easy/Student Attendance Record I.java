class Solution {
  public boolean checkRecord(String s) {
    int absentCount = 0;
    for (int i = 0; i< s.length(); i++) {
      if (s.charAt(i) == 'A') {
        absentCount++;
      }
      else if (s.charAt(i) == 'L') {
        if (i + 1 < s.length() && i + 2 < s.length() && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L') {
          return false;
        }
      }
    }
    return absentCount <= 1;
  }
}
