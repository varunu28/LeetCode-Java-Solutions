class Solution {
  public String customSortString(String order, String s) {
    Map<Character, Integer> frequency = new HashMap<>();
    for (char c : s.toCharArray()) {
      frequency.put(c, frequency.getOrDefault(c, 0) + 1);
    }
    StringBuilder sb = new StringBuilder();
    for (char c : order.toCharArray()) {
      int count = frequency.getOrDefault(c, 0);
      while (count-- > 0) {
        sb.append(c);
      }
      frequency.put(c, 0);
    }
    for (Character key : frequency.keySet()) {
      int count = frequency.getOrDefault(key, 0);
      while (count-- > 0) {
        sb.append(key);
      }
    }
    return sb.toString();
  }
}
