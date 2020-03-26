class Solution {
  Set<String> set;
  public List<String> generateParenthesis(int n) {
    set = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    helper(n, 0, 0, sb);
    return new ArrayList<>(set);
  }
  
  private void helper(int n, int open, int close, StringBuilder sb) {
    if (sb.length() == 2 * n) {
      set.add(sb.toString());
    }
    else {
      if (open <= close) {
        sb.append('(');
        helper(n, open + 1, close, new StringBuilder(sb.toString()));
      }
      else {
        sb.append(')');
        helper(n, open, close + 1, new StringBuilder(sb.toString()));
        sb.deleteCharAt(sb.length() - 1);
        if (open < n) {
          sb.append('(');
          helper(n, open + 1, close, new StringBuilder(sb.toString())); 
        }
      }
    }
  }
}
