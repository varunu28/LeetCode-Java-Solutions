class Solution {
  public boolean checkString(String s) {
    boolean aFound = false;
    boolean bFound = false;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'a') {
        if (bFound) {
          return false;
        }
        aFound = true;
      } else {
        bFound = true;
      }
    }
    return true;
  }
}
