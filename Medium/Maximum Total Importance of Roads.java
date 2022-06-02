class Solution {
  public long maximumImportance(int n, int[][] roads) {
    int[] outDegree = new int[n];
    for (int[] road : roads) {
      outDegree[road[0]]++;
      outDegree[road[1]]++;
    }
    Arrays.sort(outDegree);
    long totalImportance = 0;
    long importanceMultiple = 1L;
    for (int count : outDegree) {
      totalImportance += importanceMultiple * count;
      importanceMultiple++;
    }
    return totalImportance;
  }
}
