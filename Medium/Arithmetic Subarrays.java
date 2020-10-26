class Solution {
  public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
    List<Boolean> queryResult = new ArrayList<>();
    for (int idx = 0; idx < l.length; idx++) {
      queryResult.add(isArithmeticProgressionPossible(nums, l[idx], r[idx]));
    }
    return queryResult;
  }
  
  private boolean isArithmeticProgressionPossible(int[] nums, int startIdx, int endIdx) {
    List<Integer> sequence = new ArrayList<>();
    for (int idx = startIdx; idx <= endIdx; idx++) {
      sequence.add(nums[idx]);
    }
    Collections.sort(sequence);
    Integer diff = sequence.get(1) - sequence.get(0);
    for (int idx = 2; idx < sequence.size(); idx++) {
      if (diff != (sequence.get(idx) - sequence.get(idx - 1))) {
        return false;
      }
    }
    return true;
  }
}
