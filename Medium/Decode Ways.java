class Solution {
  
  public int numDecodings(String s) {
    Map<Integer, Integer> map = new HashMap<>();
    return helper(s, 0, map);
  } 
  
  private int helper(String s, int idx, Map<Integer, Integer> map) {
    if (map.containsKey(idx)) {
      return map.get(idx);
    }
    if (idx == s.length()) {
      return 1;
    }
    if (s.charAt(idx) == '0') {
      return 0;
    }
    if (idx == s.length() - 1) {
      return 1;
    }
    int result = helper(s, idx + 1, map);
    if (Integer.parseInt(s.substring(idx, idx + 2)) <= 26) {
      result += helper(s, idx + 2, map);
    }
    map.put(idx, result);
    return result;
  }
}
