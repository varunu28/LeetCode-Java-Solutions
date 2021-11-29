class Solution {
  public List<Integer> targetIndices(int[] nums, int target) {
    int count = 0;
    int lessThanCount = 0;
    for (int num : nums) {
      if (num == target) {
        count++;
      }
      if (num < target) {
        lessThanCount++;
      }
    }
    List<Integer> indices = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      indices.add(lessThanCount + i);
    }
    return indices;
  }
}
