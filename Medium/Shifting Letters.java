class Solution {
  public String shiftingLetters(String s, int[] shifts) {
    long totalShifts = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = shifts.length - 1; i >= 0; i--) {
      totalShifts += shifts[i];
      sb.append(getShiftedChar(s.charAt(i), totalShifts));
    }
    return sb.reverse().toString();
  }
  
  private char getShiftedChar(char c, long shifts) {
    long newAscii = ((int) c) + (shifts % 26);
    return (char) (newAscii > 122 ? (97 + (newAscii - 122) - 1) : newAscii);
  }
}
