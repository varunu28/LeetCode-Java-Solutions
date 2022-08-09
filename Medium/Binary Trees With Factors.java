class Solution {
  private final int MOD = 1_000_000_007;
  
  public int numFactoredBinaryTrees(int[] arr) {
    int n = arr.length;
    Arrays.sort(arr);
    long[] dp = new long[n];
    Arrays.fill(dp, 1);
    Map<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      indexMap.put(arr[i], i);
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] % arr[j] == 0) {
          int right = arr[i] / arr[j];
          if (indexMap.containsKey(right)) {
            dp[i] = (dp[i] + dp[j] * dp[indexMap.get(right)]) % MOD;
          }
        }
      }
    }
    long result = 0;
    for (long count : dp) {
      result += count;
    }
    return (int) (result % MOD);
  }
}
