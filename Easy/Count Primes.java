class Solution {
  public int countPrimes(int n) {
    boolean[] isPrime = new boolean[n];
    Arrays.fill(isPrime, true);
    for (int i = 2; i * i < n; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j < n; j += i) {
          isPrime[j] = false;
        }
      }
    }
    int numOfPrimes = 0;
    for (int i = 2; i < n; i++) {
      numOfPrimes += isPrime[i] ? 1 : 0;
    }
    return numOfPrimes;
  }
}
