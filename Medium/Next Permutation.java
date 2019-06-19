class Solution {
    public void nextPermutation(int[] nums) {
        // Keep moving right to left until a down slope is found
        boolean noChange = true;
        int right = nums.length - 1;
        int start = right;
        while (start >= 1) {
            // When found, swap the number with rightmost digit which is greater 
            // than the digit on the down slope
            if (nums[start] > nums[start - 1]) {
                int idx = right;
                while (nums[idx] <= nums[start - 1]) {
                    idx--;
                }
                
                int temp = nums[start - 1];
                nums[start - 1] = nums[idx];
                nums[idx] = temp;
                noChange = false;
                break;
            }
            
            start--;
        }
        
        if (noChange) {
            Arrays.sort(nums);
            return;
        }
        
        // Reverse everything to the right of down slope
        while (start < right) {
            int temp = nums[start];
            nums[start] = nums[right];
            nums[right] = temp;
            start++;
            right--;
        }
    }
}
