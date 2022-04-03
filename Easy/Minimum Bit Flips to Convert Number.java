class Solution {
  public int minBitFlips(int start, int goal) {
    int numOfFlips = 0;
    while (start > 0 && goal > 0) {
      numOfFlips += start % 2 != goal % 2 ? 1 : 0;
      start /= 2;
      goal /= 2;
    }
    while (start > 0) {
      numOfFlips += start % 2;
      start /= 2;
    }
    while (goal > 0) {
      numOfFlips += goal % 2;
      goal /= 2;
    }
    return numOfFlips;
  }
}
