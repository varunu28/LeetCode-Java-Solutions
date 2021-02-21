class Solution {
  public int brokenCalc(int X, int Y) {
    int count = 0;
    while (Y > X) {
      count++;
      Y = Y % 2 == 1 ? Y + 1 : Y / 2;
    }
    return count + X - Y;
  }
}
