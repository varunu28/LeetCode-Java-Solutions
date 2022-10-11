class Solution {
  public boolean areAlmostEqual(String s1, String s2) {
    int mismatchIdx = -1;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        if (mismatchIdx != -1) {
          return s1.charAt(mismatchIdx) == s2.charAt(i) && 
            s1.charAt(i) == s2.charAt(mismatchIdx) && 
            s1.substring(i + 1).equals(s2.substring(i + 1));
        }
        mismatchIdx = i;
      }
    }
    return mismatchIdx == -1;
  }
}
