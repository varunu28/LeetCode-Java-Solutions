class Solution {
  public int maxLengthBetweenEqualCharacters(String s) {
    Map<Character, Integer> startIndex = new HashMap<>();
    int largestSubstringLength = -1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      startIndex.putIfAbsent(c, i);
      largestSubstringLength = Math.max(largestSubstringLength, i - startIndex.get(c) - 1);
    }
    return largestSubstringLength;
  }
}
