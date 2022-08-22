class Solution {
  public List<Integer> targetIndices(int[] nums, int target) {
    int count = 0;
    int lessThanCount = 0;
    for (int num : nums) {
      count += num == target ? 1 : 0;
      lessThanCount += num < target ? 1 : 0;
    }
    List<Integer> result = new ArrayList<>();
    while (count-- > 0) {
      result.add(lessThanCount++);
    }
    return result;
  }
}
