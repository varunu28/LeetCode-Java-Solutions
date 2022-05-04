class Solution {
  public boolean isAlienSorted(String[] words, String order) {
    Map<Character, Integer> map = new HashMap<>();
    int idx = 0;
    for (char c : order.toCharArray()) {
      map.put(c, idx++);
    }
    for (int i = 1; i < words.length; i++) {
      if (!isSorted(words[i - 1], words[i], map)) {
        return false;
      }
    }
    return true;
  }
  
  private boolean isSorted(String wordOne, String wordTwo, Map<Character, Integer> map) {
    for (int i = 0; i < Math.min(wordOne.length(), wordTwo.length()); i++) {
      int diff = map.get(wordOne.charAt(i)) - map.get(wordTwo.charAt(i));
      if (diff > 0) {
        return false;
      } else if (diff < 0) {
        return true;
      }
    }
    return wordOne.length() <= wordTwo.length();
  }
}
