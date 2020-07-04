class Solution {
  public boolean isUgly(int num) {
    if (num <= 0) {
      return false;
    }
    long lNum = (long) num;
    while (lNum > 1) {
      if (lNum % 2 == 0) {
        lNum /= 2;
      }
      else if (lNum % 3 == 0) {
        lNum /= 3;
      }
      else if (lNum % 5 == 0) {
        lNum /= 5;
      }
      else {
        return false;
      }
    }
    return true;
  }
}
