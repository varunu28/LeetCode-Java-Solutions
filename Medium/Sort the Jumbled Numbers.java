class Solution {
  public int[] sortJumbled(int[] mapping, int[] nums) {
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
      if (o1[0] != o2[0]) {
        return o1[0] - o2[0];
      }
      return o1[1] - o2[1];
    });
    for (int i = 0; i < nums.length; i++) {
      priorityQueue.add(new int[]{getUpdatedNumAfterMapping(nums[i], mapping), i, nums[i]});
    }
    for (int i = 0; i < nums.length; i++) {
      nums[i] = priorityQueue.poll()[2];
    }
    return nums;
  }

  private int getUpdatedNumAfterMapping(Integer original, int[] mapping) {
    if (original <= 9) {
      return mapping[original];
    }
    int updatedNum = 0;
    int factor = 1;
    while (original > 0){
      updatedNum += mapping[original % 10] * factor;
      factor *= 10;
      original /= 10;
    }
    return updatedNum;
  }
}
