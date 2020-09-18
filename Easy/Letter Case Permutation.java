class Solution {
  public List<String> letterCasePermutation(String S) {
    Set<String> set = new HashSet<>();
    helper(S, 0, set, new StringBuilder());
    return new ArrayList<>(set);
  }
  
  private void helper(String s, int idx, Set<String> set, StringBuilder sb) {
    if (idx == s.length()) {
      if (sb.length() > 0) {
        set.add(new StringBuilder(sb.toString()).toString());
      }
    }
    else {
      char c = s.charAt(idx);
      if (Character.isDigit(c)) {
        sb.append(c);
        helper(s, idx + 1, set, sb);
        sb.deleteCharAt(sb.length() - 1);
      }
      else {
        sb.append(Character.toLowerCase(c));
        helper(s, idx + 1, set, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(Character.toUpperCase(c));
        helper(s, idx + 1, set, sb);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
}
