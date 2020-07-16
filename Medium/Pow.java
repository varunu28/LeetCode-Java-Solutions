class Solution {
  public double myPow(double x, int n) {
    long N = n;
    if (N < 0) {
      x = 1 / x;
      N = -N;
    }
    double ans = 1;
    double currProd = x;
    for (long i = N; i > 0; i /= 2) {
      if ((i % 2) == 1) {
        ans = ans * currProd;
      }
      currProd = currProd * currProd;
    }
    return ans;
  }
}
