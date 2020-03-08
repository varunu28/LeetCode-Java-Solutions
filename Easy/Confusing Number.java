class Solution {
  public boolean confusingNumber(int N) {
    int newNum = 0;
    int copy = N;
    while (N > 0) {
      int rem = N % 10;
      N /= 10;
      if (rem == 0 || rem == 1 || rem == 8) {
        newNum = newNum * 10 + rem;
      }
      else if (rem == 6 || rem == 9) {
        newNum = newNum * 10 + (rem == 6 ? 9 : 6);
      }
      else {
        return false;
      }
    }
    return newNum != copy;
  }
}
