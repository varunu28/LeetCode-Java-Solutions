class Solution {
  public String customSortString(String S, String T) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < S.length(); i++) {
      set.add(S.charAt(i));
    }
    Map<Character, Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    for (char c : T.toCharArray()) {
      if (set.contains(c)) {
        map.put(c, map.getOrDefault(c, 0) + 1);
      }
      else {
        sb.append(c);
      }
    }
    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);
      int count = map.getOrDefault(c, 0);
      while (count-- > 0) {
        sb.append(c);
      }
    }
    return sb.toString();
  }
}
