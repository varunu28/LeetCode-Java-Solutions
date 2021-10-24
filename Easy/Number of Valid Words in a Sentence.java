class Solution {
  
  public int countValidWords(String sentence) {
    return (int) Arrays.stream(sentence.split("\\s+")).filter(Solution::isValidWord).count();
  }

  public static boolean isValidWord(String s) {
    if (s.isEmpty()
        || s.charAt(0) == '-'
        || s.charAt(s.length() - 1) == '-'
        || (s.length() > 1 && !Character.isLetter(s.charAt(0)))) {
      return false;
    }
    boolean punctuationFound = false;
    boolean hyphenFound = false;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        return false;
      }
      if (c == '-') {
        if (hyphenFound || !(Character.isLetter(s.charAt(i - 1)) && Character.isLetter(s.charAt(i + 1)))) {
          return false;
        }
        hyphenFound = true;
      } else if (!Character.isLetter(c)) {
          if (punctuationFound || i != s.length() - 1) {
            return false;
          }
          punctuationFound = true;
      }
    }
    return true;
  }
}
