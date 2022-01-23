class Solution {
  public int[] rearrangeArray(int[] nums) {
    List<Integer> positive = new ArrayList<>();
    List<Integer> negative = new ArrayList<>();
    for (int num : nums) {
      if (num > 0) {
        positive.add(num);
      } else {
        negative.add(num);
      }
    }
    int positiveIdx = 0;
    int negativeIdx = 0;
    boolean positiveFlag = true;
    for (int i = 0; i < nums.length; i++) {
      nums[i] = positiveFlag ? positive.get(positiveIdx++) : negative.get(negativeIdx++);
      positiveFlag = !positiveFlag;
    }
    return nums;
  }
}
