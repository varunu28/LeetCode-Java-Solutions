class Solution {
  public String oddString(String[] words) {
    Map<String, Set<String>> diffCounter = new HashMap<>();
    for (String word : words) {
      String key = getDiffCounter(word);
      diffCounter.computeIfAbsent(key, k -> new HashSet<>()).add(word);
    }
    for (String key : diffCounter.keySet()) {
      if (diffCounter.get(key).size() == 1) {
        return diffCounter.get(key).iterator().next();
      }
    }
    return "";
  }
  
  private static String getDiffCounter(String word) {
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < word.length(); i++) {
      sb.append(word.charAt(i) - word.charAt(i - 1)).append('|');
    }
    return sb.toString();
  }
}
