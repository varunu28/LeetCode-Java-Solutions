class Solution {
  public boolean wordPattern(String pattern, String str) {
    StringBuilder patternSb = new StringBuilder();
    Map<Character, Integer> patternMap = new HashMap<>();
    int count = 0;
    for (char c : pattern.toCharArray()) {
      if (!patternMap.containsKey(c)) {
        patternMap.put(c, count++);
      }
      patternSb.append(patternMap.get(c));
    }
    StringBuilder strSb = new StringBuilder();
    Map<String, Integer> strMap = new HashMap<>();
    count = 0;
    for (String s : str.split("\\s+")) {
      if (!strMap.containsKey(s)) {
        strMap.put(s, count++);
      }
      strSb.append(strMap.get(s));
    }
    return patternSb.toString().equals(strSb.toString());
  }
}
