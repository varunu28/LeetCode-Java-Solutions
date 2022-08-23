class Solution {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int gIdx = 0;
    int sIdx = 0;
    while (sIdx < s.length && gIdx < g.length) {
      if (s[sIdx] >= g[gIdx]) {
        gIdx++;
      }
      sIdx++;
    }
    return gIdx;
  }
}
