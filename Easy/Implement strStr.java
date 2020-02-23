class Solution {
  public int strStr(String haystack, String needle) {
    int hayLength = haystack.length();
    int needleLength = needle.length();
    int idx = 0;
    while (idx + needleLength <= hayLength) {
      if (haystack.substring(idx, idx + needleLength).equals(needle)) {
        return idx;
      }
      idx++;
    }
    return -1;
  }
}
