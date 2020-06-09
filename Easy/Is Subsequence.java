class Solution {
  public boolean isSubsequence(String s, String t) {
    int idxS = 0;
    int idxT = 0;
    int lenS = s.length();
    int lenT = t.length();
    while (idxS < lenS && idxT < lenT) {
      if (s.charAt(idxS) == t.charAt(idxT)) {
        idxS++;
      }
      idxT++;
    }
    return idxS == lenS;
  }
}
