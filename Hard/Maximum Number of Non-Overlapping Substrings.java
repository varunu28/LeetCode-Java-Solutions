class Solution {
  public List<String> maxNumOfSubstrings(String s) {
    int[] leftIdx = new int[26];
    int[] rightIdx = new int[26];
    Arrays.fill(leftIdx, s.length());
    List<String> ans = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      int c = s.charAt(i) - 'a';
      leftIdx[c] = Math.min(i, leftIdx[c]);
      rightIdx[c] = i;
    }
    int right = -1;
    for (int i = 0; i < s.length(); i++) {
      if (i == leftIdx[s.charAt(i) - 'a']) {
        int newRight = helper(s, i, leftIdx, rightIdx);
        if (newRight != -1) {
          if (i > right) {
            ans.add("");
          }
          right = newRight;
          ans.set(ans.size() - 1, s.substring(i, right + 1));
        }
      }
    }
    return ans;
  }
  
  private int helper(String s, int idx, int[] leftIdx, int[] rightIdx) {
    int right = rightIdx[s.charAt(idx) - 'a'];
    for (int i = idx; i <= right; i++) {
      if (leftIdx[s.charAt(i) - 'a'] < idx) {
        return -1;
      }
      right = Math.max(right, rightIdx[s.charAt(i) - 'a']);
    }
    return right;
  }
}
