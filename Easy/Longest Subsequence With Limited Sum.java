class Solution {
  public int[] answerQueries(int[] nums, int[] queries) {
    Arrays.sort(nums);
    Arrays.parallelPrefix(nums, Integer::sum);
    for (int i = 0; i < queries.length; i++) {
      int idx = Arrays.binarySearch(nums, queries[i]);
      queries[i] = Math.abs(idx + 1);
    }
    return queries;
  }
}
