class Solution {
  private final char[] ALL_CHARACTERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();
  public String modifyString(String s) {
    char[] charArray = s.toCharArray();
    for (int idx = 0; idx < charArray.length; idx++) {
      if (charArray[idx] == '?') {
        charArray[idx] = getNonRepeatingChar(charArray, idx);
      }
    }
    return String.valueOf(charArray);
  }
  
  private char getNonRepeatingChar(char[] charArray, int idx) {
    for (char c : ALL_CHARACTERS) {
      if ((idx == 0 || charArray[idx - 1] == '?' || charArray[idx - 1] != c) && 
          (idx == charArray.length - 1 || charArray[idx + 1] == '?' || charArray[idx + 1] != c)) {
        return c;
      }
    }
    return charArray[idx];
  }
}
