class Solution {
  public List<String> findAndReplacePattern(String[] words, String pattern) {
    String patternCode = getCode(pattern);
    List<String> list = new ArrayList<>();
    for (String word : words) {
      String wordCode = getCode(word);
      if (wordCode.equals(patternCode)) {
        list.add(word);
      }
    }
    return list;
  }
  
  private String getCode(String word) {
    Map<Character, Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    int count = 0;
    for (char c : word.toCharArray()) {
      if (!map.containsKey(c)) {
        map.put(c, count++);
      }
      sb.append(map.get(c));
    }
    return sb.toString();
  }
}
