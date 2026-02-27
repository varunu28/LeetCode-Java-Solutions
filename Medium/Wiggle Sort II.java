class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int median = findMedian(nums, n / 2);
        int left = 0;
        int right = n - 1;
        int idx = 0;
        int oddLength = n % 2 == 0 ? n + 1 : n;
        while (idx <= right) {
            int mappedIdx = (2 * idx + 1) % oddLength;
            if (nums[mappedIdx] > median) {
                int mappedLeft = (2 * left + 1) % oddLength;
                swap(nums, mappedLeft, mappedIdx);
                left++;
                idx++;
            } else if (nums[mappedIdx] < median) {
                int mappedRight = (2 * right + 1) % oddLength;
                swap(nums, mappedRight, mappedIdx);
                right--;
            } else {
                idx++;
            }
        }
    }

    private int findMedian(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == k) {
                return nums[k];
            }
            if (pivotIndex < k) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
