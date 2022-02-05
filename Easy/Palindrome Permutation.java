class Solution {
  public boolean canPermutePalindrome(String s) {
    Map<Character, Integer> frequencyMap = new HashMap<>();
    for (char c : s.toCharArray()) {
      frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
    }
    boolean oddFound = false;
    for (Character key : frequencyMap.keySet()) {
      if (frequencyMap.get(key) % 2 != 0) {
        if (oddFound) {
          return false;
        }
        oddFound = true;
      }
    }
    return true;
  }
}
