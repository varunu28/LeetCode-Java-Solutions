class Solution {
  public boolean validWordAbbreviation(String word, String abbr) {
    int wordIdx = 0;
    int abbrIdx = 0;
    while (wordIdx < word.length() && abbrIdx < abbr.length()) {
      if (Character.isDigit(abbr.charAt(abbrIdx))) {
        if (abbr.charAt(abbrIdx) == '0') {
          return false;
        }
        int count = 0;
        while (abbrIdx < abbr.length() && Character.isDigit(abbr.charAt(abbrIdx))) {
          count = count * 10 + Character.getNumericValue(abbr.charAt(abbrIdx++));
        }
        wordIdx += count;
        if (wordIdx > word.length()) {
          return false;
        }
      } else {
        if (word.charAt(wordIdx) != abbr.charAt(abbrIdx)) {
          return false;
        }
        wordIdx++;
        abbrIdx++;
      }
    }
    return wordIdx == word.length() && abbrIdx == abbr.length();
  }
}
