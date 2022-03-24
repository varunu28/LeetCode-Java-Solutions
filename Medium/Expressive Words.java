class Solution {
  public int expressiveWords(String s, String[] words) {
    return (int) Arrays.stream(words).filter(word -> isExpressive(s, word)).count();
  }
  
  private boolean isExpressive(String s, String word) {
    int sIdx = 0;
    int wordIdx = 0;
    while (sIdx < s.length() && wordIdx < word.length()) {
      if (s.charAt(sIdx) != word.charAt(wordIdx)) {
        return false;
      }
      char c1 = s.charAt(sIdx);
      int countC1 = 0;
      while (sIdx < s.length() && s.charAt(sIdx) == c1) {
        sIdx++;
        countC1++;
      }
      char c2 = word.charAt(wordIdx);
      int countC2 = 0;
      while (wordIdx < word.length() && word.charAt(wordIdx) == c2) {
        wordIdx++;
        countC2++;
      }
      if (countC1 == countC2 || (countC1 > countC2 && countC1 >= 3)) {
        continue;
      }
      return false;
    }
    return sIdx == s.length() && wordIdx == word.length();
  }
}
