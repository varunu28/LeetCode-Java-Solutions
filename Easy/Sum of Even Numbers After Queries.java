class Solution {
  public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
    int sum = 0;
    for (int num : A) {
      sum += num % 2 == 0 ? num : 0;
    }
    int[] ans = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int newVal = A[queries[i][1]] + queries[i][0];
      if (A[queries[i][1]] % 2 == 0) {
        sum -= A[queries[i][1]];
      }
      A[queries[i][1]] = newVal;
      if (A[queries[i][1]] % 2 == 0) {
        sum += newVal;
      }
      ans[i] = sum;
    }
    return ans;
  }
}
