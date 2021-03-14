class Solution {
  public final int UNSET_INDEX = -1;
  public final int SET_INDEX = 101;
  public boolean areAlmostEqual(String s1, String s2) {
    int swapIndex = UNSET_INDEX;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        if (swapIndex == SET_INDEX) {
          return false;
        } else if (swapIndex == UNSET_INDEX) {
          swapIndex = i;
        } else {
          if (!(s1.charAt(swapIndex) == s2.charAt(i) && s1.charAt(i) == s2.charAt(swapIndex))) {
            return false;
          }
          swapIndex = SET_INDEX;
        }
      }
    }
    return swapIndex == UNSET_INDEX || swapIndex == SET_INDEX;
  }
}
