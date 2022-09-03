class Solution {
  public int[] numsSameConsecDiff(int n, int k) {
    List<Integer> result = new ArrayList<>();
    helper(n, k, result, new StringBuilder());
    return result.stream().mapToInt(Integer::intValue).toArray();
  }

  private void helper(int n, int k, List<Integer> result, StringBuilder sb) {
    if (sb.length() == n) {
      result.add(Integer.parseInt(sb.toString()));
      return;
    }
    for (int i = 0; i <= 9; i++) {
      if (sb.isEmpty() && i == 0) {
        continue;
      }
      if (!sb.isEmpty()
          && Math.abs(Character.getNumericValue(sb.charAt(sb.length() - 1)) - i) != k) {
        continue;
      }
      sb.append(i);
      helper(n, k, result, new StringBuilder(sb));
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
