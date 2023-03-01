class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
  
    private void mergeSort(int[] nums, int start, int end) {
        if (end - start <= 0) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }
  
    private void merge(int[] nums, int start, int mid, int end) {
        int left = start;
        int right = mid + 1;
        int[] temp = new int[end - start + 1];
        int idx = 0;
        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                temp[idx++] = nums[left++];
            } else {
                temp[idx++] = nums[right++];
            }
        }
        while (left <= mid) {
            temp[idx++] = nums[left++];
        }
        while (right <= end) {
            temp[idx++] = nums[right++];
        }
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i - start];
        }
    }
}
