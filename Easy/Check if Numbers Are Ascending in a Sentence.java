class Solution {
  public boolean areNumbersAscending(String s) {
    int prevValue = Integer.MIN_VALUE;
    for (int i = 0; i < s.length(); ) {
      if (Character.isDigit(s.charAt(i))) {
        int currNum = 0;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
          currNum = currNum * 10 + Character.getNumericValue(s.charAt(i++));
        }
        if (currNum <= prevValue) {
          return false;
        }
        prevValue = currNum;
      }
      i++;
    }
    return true;
  }
}
