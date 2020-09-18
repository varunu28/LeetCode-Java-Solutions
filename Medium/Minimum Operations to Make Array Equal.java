class Solution {
  public int minOperations(int n) {
    return (n / 2) * ((n / 2) + n % 2);
  }
}
