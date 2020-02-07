class Solution {
  public int countCharacters(String[] words, String chars) {
    Map<Character, Integer> charFreq = getMap(chars);
    int length = 0;
    for (String word : words) {
      if (canBeFormed(charFreq, getMap(word))) {
        length += word.length();
      }
    }
    return length;
  }
  
  private Map<Character, Integer> getMap(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    return map;
  }
  
  private boolean canBeFormed(Map<Character, Integer> main, Map<Character, Integer> toBeChecked) {
    for (Character key : toBeChecked.keySet()) {
      if (main.getOrDefault(key, 0) < toBeChecked.get(key)) {
        return false;
      }
    }
    return true;
  }
}
