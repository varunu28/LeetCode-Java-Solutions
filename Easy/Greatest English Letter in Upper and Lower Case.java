class Solution {
  public String greatestLetter(String s) {
    boolean[] upperCasePresent = new boolean[26];
    boolean[] lowerCasePresent = new boolean[26];
    for (char c : s.toCharArray()) {
      if (Character.isUpperCase(c)) {
        upperCasePresent[c - 'A'] = true;
      } else {
        lowerCasePresent[c - 'a'] = true;
      }
    }
    for (int i = 25; i >= 0; i--) {
      if (upperCasePresent[i] && lowerCasePresent[i]) {
        return String.valueOf((char) ('A' + i));
      }
    }
    return "";
  }
}
