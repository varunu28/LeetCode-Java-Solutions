class Solution {
  public int smallestRepunitDivByK(int K) {
    if (K % 2 == 0 || K % 5 == 0) {
      return -1;
    }
    int remainder = 0;
    for (int n = 1; n <= K; n++) {
      remainder = (remainder * 10 + 1) % K;
      if (remainder == 0) {
        return n;
      }
    }
    return -1;
  }
}
