class Solution {
  public int subtractProductAndSum(int n) {
    int sum = 0;
    int copy = n;
    while (copy > 0) {
      sum += copy % 10;
      copy /= 10;
    }
    int prod = 1;
    copy = n;
    while (copy > 0) {
      prod *= copy % 10;
      copy /= 10;
    }
    return prod - sum;
  }
}
