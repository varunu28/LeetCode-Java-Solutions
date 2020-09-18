class Solution {
  public List<String> letterCombinations(String digits) {
    if (digits.length() == 0) {
      return new ArrayList<>();
    }
    String[] strs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    Map<Integer, String> map = new HashMap<>();
    for (int i = 2; i <= 9; i++) {
      map.put(i, strs[i - 2]);
    }
    List<String> list = new ArrayList<>();
    helper(digits, 0, digits.length(), new StringBuilder(), map, list);
    return list;
  }
  
  private void helper(
    String digits, int idx, int n, StringBuilder sb, Map<Integer, String> map, List<String> list
  ) {
    if (idx == n) {
      if (sb.length() == n) {
        list.add(sb.toString());
      }
    }
    else {
      for (int i = idx; i < n; i++) {
        int digit = Character.getNumericValue(digits.charAt(i));
        for (char c : map.get(digit).toCharArray()) {
          sb.append(c);
          helper(digits, i + 1, n, sb, map, list);
          sb.deleteCharAt(sb.length() - 1);
        }
      }
    }
  }
}
