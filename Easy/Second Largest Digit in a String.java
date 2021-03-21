class Solution {
  public int secondHighest(String s) {
    int maximumNum = -1;
    int secondMaximumNum = -1;
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        int num = Character.getNumericValue(c);
        if (maximumNum < num) {
          if (secondMaximumNum < maximumNum) {
            secondMaximumNum = maximumNum;
          }
          maximumNum = num;
        } else if (secondMaximumNum < num && num < maximumNum) {
          secondMaximumNum = num;
        }
      }
    }
    return secondMaximumNum;
  }
}
