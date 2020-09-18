class Solution {
  public int[] numsSameConsecDiff(int N, int K) {
    if (N == 1) {
      return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    }
    Set<Integer> set = new HashSet<>();
    for (int i = 1; i <= 9; i++) {
      helper(i, new StringBuilder(), K, set, N);
    }
    int[] ans = new int[set.size()];
    Iterator<Integer> iterator = set.iterator();
    for (int i = 0; i < ans.length; i++) {
      ans[i] = iterator.next();
    }
    return ans;
  }

  private void helper(int curr, StringBuilder sb, int k, Set<Integer> set, int n) {
    if (sb.length() == n) {
      set.add(Integer.parseInt(sb.toString()));
    }
    if (sb.length() > n || curr > 9 || curr < 0) {
      return;
    }
    else {
      sb.append(curr);
      helper(curr + k, sb, k, set, n);
      helper(curr - k, sb, k, set, n);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
