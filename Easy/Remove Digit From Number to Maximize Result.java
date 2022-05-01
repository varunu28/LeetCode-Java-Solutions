class Solution {
  public String removeDigit(String number, char digit) {
    int lastOccurrence = -1;
    for (int i = 0; i < number.length(); i++) {
      if (number.charAt(i) == digit) {
        if (i + 1 < number.length() && number.charAt(i + 1) > digit) {
          return number.substring(0, i) + number.substring(i + 1);
        }
        lastOccurrence = i;
      }
    }
    return number.substring(0, lastOccurrence) + number.substring(lastOccurrence + 1);
  }
}
