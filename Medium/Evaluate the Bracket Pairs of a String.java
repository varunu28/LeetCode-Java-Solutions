class Solution {
  public String evaluate(String s, List<List<String>> knowledge) {
    Map<String, String> map = new HashMap<>();
    for (List<String> entry : knowledge) {
      map.put(entry.get(0), entry.get(1));
    }
    StringBuilder sb = new StringBuilder();
    int idx = 0;
    int n = s.length();
    while (idx < n) {
      if (s.charAt(idx) == '(') {
        idx++;
        int currIdx = idx;
        while (idx < n && s.charAt(idx) != ')') {
          idx++;
        }
        sb.append(map.getOrDefault(s.substring(currIdx, idx++), "?"));
      } else {
        sb.append(s.charAt(idx++));
      }
    }
    return sb.toString();
  }
}
