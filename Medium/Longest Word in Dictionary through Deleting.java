class Solution {
  public String findLongestWord(String s, List<String> d) {
    d.sort((o1, o2) -> o1.length() != o2.length() ? Integer.compare(o2.length(), o1.length())
        : o1.compareTo(o2));
    for (String word : d) {
      int wordIdx = 0;
      int strIdx = 0;
      while (strIdx < s.length() && wordIdx < word.length()) {
        if (word.charAt(wordIdx) == s.charAt(strIdx)) {
          wordIdx++;
        }
        strIdx++;
      }
      if (wordIdx == word.length()) {
        return word;
      }
    }
    return "";
  }
}
