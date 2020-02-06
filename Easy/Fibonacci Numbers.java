class Solution {
  public int fib(int N) {
    Integer[] memo = new Integer[N + 1];
    return getFib(memo, N);
  }
  
  private int getFib(Integer[] memo, int N) {
    if (memo[N] != null) {
      return memo[N];
    }
    else if (N == 0) {
      return 0;
    }
    else if (N == 1) {
      return 1;
    }
    memo[N] = getFib(memo, N - 1) + getFib(memo, N - 2);
    return memo[N];
  }
}
