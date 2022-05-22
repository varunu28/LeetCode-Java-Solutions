class Solution {
  public int percentageLetter(String s, char letter) {
    int letterCount = 0;
    for (char c : s.toCharArray()) {
      if (c == letter) {
        letterCount++;
      }
    }
    return (letterCount * 100) / s.length();
  }
}
