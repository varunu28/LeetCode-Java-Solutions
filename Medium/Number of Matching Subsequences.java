class Solution {
  public int numMatchingSubseq(String s, String[] words) {
    Map<Character, List<int[]>> map = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      map.computeIfAbsent(words[i].charAt(0), k -> new ArrayList<>()).add(new int[]{0, i});
    }
    int result = 0;
    for (char c : s.toCharArray()) {
      List<int[]> values = map.getOrDefault(c, new ArrayList<>());
      map.put(c, new ArrayList<>());
      for (int[] val : values) {
        int stringIdx = val[0];
        int wordIdx = val[1];
        if (stringIdx + 1 == words[wordIdx].length()) {
          result++;
        } else {
          char nextChar = words[wordIdx].charAt(stringIdx + 1);
          map.computeIfAbsent(nextChar, k -> new ArrayList<>()).add(new int[]{stringIdx + 1, wordIdx});
        }
      }
    }
    return result;
  }
}
