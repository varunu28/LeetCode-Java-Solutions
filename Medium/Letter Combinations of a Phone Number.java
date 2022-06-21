class Solution {
  
  private final List<String> LETTER_MAPPING = Arrays.asList("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz");
  
  public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    helper(digits, 0, new StringBuilder(), result);
    return result;
  }
  
  private void helper(String digits, int idx, StringBuilder sb, List<String> result) {
    if (idx == digits.length()) {
      if (sb.length() > 0) {
        result.add(new String(sb.toString()));
      }
      return;
    } 
    int mappingIdx = Character.getNumericValue(digits.charAt(idx)) - 2;
    for (char c : LETTER_MAPPING.get(mappingIdx).toCharArray()) {
      sb.append(c);
      helper(digits, idx + 1, sb, result);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
