class Solution {
  public int numberOfSubstrings(String s) {
    int[] indexes = new int[]{-1, -1, -1};
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      indexes[s.charAt(i) - 'a'] = i;
      if (indexes[0] != -1 && indexes[1] != -1 && indexes[2] != -1) {
        count += Math.min(indexes[0], Math.min(indexes[1], indexes[2])) + 1;
      }
    }
    return count;
  }
}
