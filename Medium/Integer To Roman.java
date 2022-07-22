class Solution {
  
  private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
  private static final String[] symbols = {
    "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
  
  public String intToRoman(int num) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < values.length && num > 0; i++) {
      int factor = num / values[i];
      num %= values[i];
      if (factor > 0) {
        for (int j = 1; j <= factor; j++) {
          sb.append(symbols[i]);
        }
      }
    }
    return sb.toString();
  }
}
