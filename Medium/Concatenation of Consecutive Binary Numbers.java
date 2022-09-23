class Solution {
  public int concatenatedBinary(int n) {
    final int MOD = 1000_000_007;
    int length = 0;
    long result = 0;
    for (int i = 1; i <= n; i++) {
      if (Math.pow(2, (int) (Math.log(i) / Math.log(2))) == i) {
        length++;
      }
      result = ((result * (int) Math.pow(2, length)) + i) % MOD;
    }
    return (int) result;
  }
}
