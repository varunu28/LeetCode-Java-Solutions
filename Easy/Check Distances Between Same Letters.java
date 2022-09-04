class Solution {
  public boolean checkDistances(String s, int[] distance) {
    Map<Character, Integer> charToIdx = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (charToIdx.containsKey(s.charAt(i))) {
        int diff = i - charToIdx.get(s.charAt(i)) - 1;
        if (diff != distance[s.charAt(i) - 'a']) {
          return false;
        }
      } else {
        charToIdx.put(s.charAt(i), i);
      }
    }
    return true;
  }
}
