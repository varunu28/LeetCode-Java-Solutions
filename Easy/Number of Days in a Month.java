class Solution {
  final int[] DAY_COUNT = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  public int numberOfDays(int Y, int M) {
    boolean isLeapYear = Y % 4 == 0 && ((Y % 100 == 0) ? (Y % 400 == 0) : true);
    return DAY_COUNT[M - 1] + (M == 2 ? (isLeapYear ? 1 : 0) : 0);
  }
}
