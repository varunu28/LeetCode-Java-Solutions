class Solution {
  public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == key) {
        int start = Math.max(result.size() == 0 ? 0 : result.get(result.size() - 1) + 1, i - k);
        for (int j = start; j <= i + k && j < nums.length; j++) {
          result.add(j);
        }
      }
    }
    return result;
  }
}
