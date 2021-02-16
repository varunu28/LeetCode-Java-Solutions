class Solution {
  public List<String> letterCasePermutation(String S) {
    List<String> result = new ArrayList<>();
    helper(S, 0, new StringBuilder(), result);
    return result;
  }
  
  private void helper(String s, int idx, StringBuilder sb, List<String> result) {
    if (idx == s.length()) {
      result.add(new String(sb.toString()));
    } else {
      if (Character.isDigit(s.charAt(idx))) {
        sb.append(s.charAt(idx));
        helper(s, idx + 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
      } else {
        sb.append(Character.toLowerCase(s.charAt(idx)));
        helper(s, idx + 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(Character.toUpperCase(s.charAt(idx)));
        helper(s, idx + 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
}
