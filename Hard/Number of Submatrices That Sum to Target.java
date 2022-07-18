class Solution {
  public int numSubmatrixSumTarget(int[][] matrix, int target) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    int[][] prefixSum = new int[rows + 1][cols + 1];
    for (int i = 1; i <= rows; i++) {
      for (int j = 1; j <= cols; j++) {
        prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + matrix[i - 1][j - 1];
      }
    }
    int count = 0;
    int currSum = 0;
    for (int i = 1; i <= rows; i++) {
      for (int j = i; j <= rows; j++) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int k = 1; k <= cols; k++) {
          currSum = prefixSum[j][k] - prefixSum[i - 1][k];
          count += map.getOrDefault(currSum - target, 0);
          map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
      }
    }
    return count;
  }
}
