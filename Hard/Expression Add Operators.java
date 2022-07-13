class Solution {
  public List<String> addOperators(String num, int target) {
    List<String> result = new ArrayList<>();
    helper(num, target, "", result, 0, 0, 0);
    return result;
  }
  
  private void helper(String s, long target, String path, List<String> result, int pos, long calculatedResult, long multed) {
    if (pos == s.length()) {
      if (calculatedResult == target) {
        result.add(new String(path));
      } 
      return;
    }
    for (int i = pos; i < s.length(); i++) {
      if (i != pos && s.charAt(pos) == '0') {
        break;
      }
      long curr = Long.parseLong(s.substring(pos, i + 1));
      if (pos == 0) {
        helper(s, target, path + curr, result, i + 1, curr, curr);
      } else {
          helper(s, target, path + "+" + curr, result, i + 1, calculatedResult + curr, curr);
          helper(s, target, path + "-" + curr, result, i + 1, calculatedResult - curr, -curr);
          helper(s, target, path + "*" + curr, result, i + 1, calculatedResult - multed + multed * curr, multed * curr);
      }
    }
  }
}
