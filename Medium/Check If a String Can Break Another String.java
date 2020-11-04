class Solution {
  public boolean checkIfCanBreak(String s1, String s2) {
    int n = s1.length();
    int[] counterS1 = new int[26];
    int[] counterS2 = new int[26];
    for (int idx = 0; idx < n; idx++) {
      counterS1[s1.charAt(idx) - 'a']++;
      counterS2[s2.charAt(idx) - 'a']++;
    }
    int countS1 = 0;
    int countS2 = 0;
    int side = 0;
    for (int idx = 0; idx < 26; idx++) {
      countS1 += counterS1[idx];
      countS2 += counterS2[idx];
      if (countS1 > countS2) {
        if (side == 1) {
          return false;
        }
        side = -1;
      } else if (countS2 > countS1) {
        if (side == -1) {
          return false;
        }
        side = 1;
      }
    }
    return true;
  }
}
