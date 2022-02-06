class Solution {
  public int[] pivotArray(int[] nums, int pivot) {
    int[] result = new int[nums.length];
    int leftIdx = 0;
    int rightIdx = nums.length - 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < pivot) {
        result[leftIdx++] = nums[i];
      }
      int tempIdx = nums.length - 1 - i;
      if (nums[tempIdx] > pivot) {
        result[rightIdx--] = nums[tempIdx];
      }
    }
    while (leftIdx <= rightIdx) {
      result[leftIdx++] = pivot;
    }
    return result;
  }
}
