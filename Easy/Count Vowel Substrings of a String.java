class Solution {
  public int countVowelSubstrings(String word) {
    return atMostVowel(word, 5) - atMostVowel(word, 4);
  }

  private int atMostVowel(String word, int atMostGoal) {
    int start = 0;
    int count = 0;
    int n = word.length();
    Map<Character, Integer> map = new HashMap<>();
    for (int end = 0; end < n; end++) {
      if (!isVowel(word.charAt(end))) {
        map.clear();
        start = end + 1;
      } else {
        map.put(word.charAt(end), map.getOrDefault(word.charAt(end), 0) + 1);
        for (; map.size() > atMostGoal; start++) {
          map.put(word.charAt(start), map.get(word.charAt(start)) - 1);
          if (map.get(word.charAt(start)) == 0) {
            map.remove(word.charAt(start));
          }
        }
        count += end - start + 1;
      }
    }
    return count;
  }
  
  private boolean isVowel(char c) {
    return "aeiou".indexOf(c) != -1;
  }
}
