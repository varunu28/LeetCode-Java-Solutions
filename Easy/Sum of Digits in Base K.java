class Solution {
  public int sumBase(int n, int k) {
    int digitSum = 0;
    while (n > 0) {
      digitSum += n % k;
      n /= k;
    }
    return digitSum;
  }
}
