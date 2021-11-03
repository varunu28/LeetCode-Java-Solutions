class Solution {
  public int findContentChildren(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int contentChildrenCount = 0;
    for (int i = 0, j = 0; i < s.length && j < g.length; i++) {
      if (s[i] >= g[j]) {
        contentChildrenCount++;
        j++;
      }
    }
    return contentChildrenCount;
  }
}
