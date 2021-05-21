class Solution {
  public List<String> findAndReplacePattern(String[] words, String pattern) {
    String patternString = getPattern(pattern);
    return Arrays.stream(words).filter(e -> getPattern(e).equals(patternString))
      .collect(Collectors.toList());
  }
  
  private String getPattern(String s) {
    StringBuilder sb = new StringBuilder();
    Map<Character, Integer> map = new HashMap<>();
    int count = 1;
    for (char c : s.toCharArray()) {
      if (!map.containsKey(c)) {
        map.put(c, count++);
      }
      sb.append(map.get(c));
    }
    return sb.toString();
  }
}
