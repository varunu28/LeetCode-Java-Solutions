class Solution {
  public boolean isUgly(int n) {
    int[] primes = {2, 3, 5};
    for (int i = 0; i < primes.length; i++) {
      while (n > 1 && n % primes[i] == 0) {
        n /= primes[i];
      }
    }
    return n == 1;
  }
}
