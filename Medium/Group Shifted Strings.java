class Solution {
  public List<List<String>> groupStrings(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strings) {
      map.computeIfAbsent(getShiftedCode(s), k -> new ArrayList<>()).add(s);
    }
    return new ArrayList<>(map.values());
  }

  private String getShiftedCode(String s) {
    StringBuilder key = new StringBuilder();
    for (int i = 1; i < s.length(); i++) {
      key.append(String.format("%2d", (s.charAt(i) - s.charAt(i-1) + 26) % 26));
    }
    return key.toString();
  }
}
