class Solution {
  public int findKthLargest(int[] nums, int k) {
    return quickSelect(nums, 0, nums.length - 1, nums.length - k);
  }

  private int quickSelect(int[] nums, int leftIdx, int rightIdx, int k) {
    int pivot = nums[rightIdx];
    int idx = leftIdx;
    for (int i = leftIdx; i < rightIdx; i++) {
      if (nums[i] <= pivot) {
        swap(nums, i, idx);
        idx++;
      }
    }
    swap(nums, idx, rightIdx);
    return idx == k ? nums[idx] : (idx > k ? quickSelect(nums, leftIdx, idx - 1, k) : quickSelect(nums, idx + 1, rightIdx, k));
  }

  private void swap(int[] nums, int idxOne, int idxTwo) {
    int temp = nums[idxOne];
    nums[idxOne] = nums[idxTwo];
    nums[idxTwo] = temp;
  }
}
