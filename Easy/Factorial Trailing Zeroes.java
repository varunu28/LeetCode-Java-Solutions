class Solution {
  public int trailingZeroes(int n) {
    int count = 0;
    while (n > 4) {
      count += n / 5;
      n = n / 5;
    }
    return count;
  }
}
