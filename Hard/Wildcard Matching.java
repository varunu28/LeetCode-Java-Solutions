class Solution {
  public boolean isMatch(String s, String p) {
    int sLen = s.length();
    int pLen = p.length();
    int sIdx = 0;
    int pIdx = 0;
    int startIdx = -1;
    int sTempIdx = -1;
    while (sIdx < sLen) {
      if (pIdx < pLen && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))) {
        sIdx++;
        pIdx++;
      } else if (pIdx < pLen && p.charAt(pIdx) == '*') {
        startIdx = pIdx;
        sTempIdx = sIdx;
        pIdx++;
      } else if (startIdx == -1) {
        return false;
      } else {
        pIdx = startIdx + 1;
        sIdx = sTempIdx + 1;
        sTempIdx = sIdx;
      }
    }
    for (int i = pIdx; i < pLen; i++) {
      if (p.charAt(i) != '*') {
        return false;
      }
    }
    return true;
  }
}
