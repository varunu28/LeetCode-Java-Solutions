class Solution {
  public int[] diStringMatch(String S) {
    int n = S.length();
    int low = 0;
    int high = n;
    int[] ans = new int[n + 1];
    for (int i = 0; i < n; i++) {
      ans[i] = S.charAt(i) == 'I' ? low++ : high--;
    }
    ans[n] = low;
    return ans;
  }
}
