class Solution {
  public int titleToNumber(String columnTitle) {
    int numericValue = 0;
    int multiplier = 1;
    for (int i = columnTitle.length() - 1; i >= 0; i--) {
      int currCharNum = columnTitle.charAt(i) - 'A' + 1;
      numericValue += multiplier * currCharNum;
      multiplier *= 26;
    }
    return numericValue; 
  }
}
