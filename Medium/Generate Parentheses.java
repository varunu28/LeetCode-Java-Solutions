class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    helper(result, 0, 0, n, new StringBuilder());
    return result;
  }
  
  private void helper(List<String> result, int start, int end, int n, StringBuilder sb) {
    if (start + end == 2 * n) {
      if (start == end) {
        result.add(new StringBuilder(sb.toString()).toString());
      }
      return;
    }
    if (start > end) {
      sb.append('(');
      helper(result, start + 1, end, n, sb);
      sb.deleteCharAt(sb.length() - 1);
      sb.append(')');
      helper(result, start, end + 1, n, sb);
      sb.deleteCharAt(sb.length() - 1);
    } else if (start == end) {
      sb.append('(');
      helper(result, start + 1, end, n, sb);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
