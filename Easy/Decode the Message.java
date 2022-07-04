class Solution {
  public String decodeMessage(String key, String message) {
    int counter = 0;
    Map<Character, Character> map = new HashMap<>();
    for (char c : key.toCharArray()) {
      if (!map.containsKey(c) && c != ' ') {
        map.put(c, (char) ('a' + counter++));
      }
    }
    StringBuilder sb = new StringBuilder();
    for (char c : message.toCharArray()) {
      sb.append(c == ' ' ? ' ' : map.get(c));
    }
    return sb.toString();
  }
}
