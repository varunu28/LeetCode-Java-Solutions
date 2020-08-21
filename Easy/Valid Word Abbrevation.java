class Solution {
  public boolean validWordAbbreviation(String word, String abbr) {
    int idx1 = 0;
    int idx2 = 0;
    while (idx1 < word.length() && idx2 < abbr.length()) {
      if (!Character.isDigit(abbr.charAt(idx2))) {
        if (word.charAt(idx1) != abbr.charAt(idx2)) {
          return false;
        }
        idx1++;
        idx2++;
      }
      else {
        if (abbr.charAt(idx2) == '0') {
          return false;
        }
        int count = 0;
        while (idx2 < abbr.length() && Character.isDigit(abbr.charAt(idx2))) {
          count = count * 10 + Character.getNumericValue(abbr.charAt(idx2++));
        }
        idx1 += count;
      }
    }
    return idx1 == word.length() && idx2 == abbr.length();
  }
}
