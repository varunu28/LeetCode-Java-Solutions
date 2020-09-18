class Solution {
  public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) {
      return "0";
    }
    StringBuilder fraction = new StringBuilder();
    if (numerator < 0 ^ denominator < 0) {
      fraction.append("-");
    }
    long dividend = Math.abs((long) numerator);
    long divisor = Math.abs((long) denominator);
    fraction.append(String.valueOf(dividend / divisor));
    long remainder = dividend % divisor;
    if (remainder == 0) {
      return fraction.toString();
    }
    fraction.append(".");
    Map<Long, Integer> map = new HashMap<>();
    while (remainder != 0) {
      if (map.containsKey(remainder)) {
        fraction.insert(map.get(remainder), "(");
        fraction.append(")");
        break;
      }
      map.put(remainder, fraction.length());
      remainder *= 10;
      fraction.append(String.valueOf(remainder / divisor));
      remainder %= divisor;
    }
    return fraction.toString();
  }
}
