class Solution {
  public String intToRoman(int num) {
    int[] divisor = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < divisor.length; i++) {
      int fact = num / divisor[i];
      while (fact-- > 0) {
        sb.append(numerals[i]);
      }
      num = num % divisor[i];
    }
    return sb.toString();
  }
}
