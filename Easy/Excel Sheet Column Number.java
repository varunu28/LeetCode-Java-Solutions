class Solution {
  public int titleToNumber(String s) {
    int num = 0;
    int pow = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      num += ((int) Math.pow(26, pow++)) * (s.charAt(i) - 'A' + 1);
    }
    return num;
  }
}
