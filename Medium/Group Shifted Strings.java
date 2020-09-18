class Solution {
  public List<List<String>> groupStrings(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strings) {
      map.computeIfAbsent(getKey(str), k -> new ArrayList<>()).add(str);
    }
    return new ArrayList<>(map.values());
  }
  
  private String getKey(String s) {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < s.length(); i++) {
      int diff = s.charAt(i) - s.charAt(i - 1);
      diff = diff < 0 ? diff + 26 : diff;
      sb.append(diff);
    }
    return sb.toString();
  }
}
