class Solution {
  public boolean isOneEditDistance(String s, String t) {
    int lengthDiff = Math.abs(s.length() - t.length());
    if (s.equals(t) || lengthDiff > 1) {
      return false;
    }
    if (s.length() == 0 || t.length() == 0) {
      return true;
    }
    int idxOne = 0;
    int idxTwo = 0;
    boolean changeDone = false;
    while (idxOne < s.length() && idxTwo < t.length()) {
      if (s.charAt(idxOne) == t.charAt(idxTwo)) {
        idxOne++;
        idxTwo++;
        continue;
      }
      if (changeDone) {
        return false;
      }
      if (lengthDiff != 0) {
        if (s.length() > t.length()) {
          idxOne++;
        } else {
          idxTwo++;
        }
      } else {
        idxOne++;
        idxTwo++;
      }
      changeDone = true;
    }
    if (changeDone && (idxOne != s.length() || idxTwo != t.length())) {
      return false;
    }
    return true;
  }
}
