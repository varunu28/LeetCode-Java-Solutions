class Solution {
    public int[] searchRange(int[] nums, int target) {
        int idx = findBinary(nums, 0, nums.length-1, target);
        int startIdx = idx;
        int endIdx = idx;
        
        int start = 0;
        int end = idx - 1;
        
        while (true) {
            int temp = findBinary(nums, start, end, target);
            if (temp != -1) {
                startIdx = temp;
                start = 0;
                end = temp - 1;
            }
            else {
                break;
            }
        }
        
        start = idx + 1;
        end = nums.length - 1;
        
        while (true) {
            int temp = findBinary(nums, start, end, target);
            if (temp != -1) {
                endIdx = temp;
                start = temp + 1;
                end = nums.length - 1;
            }
            else {
                break;
            }
        }
        
        int[] ans = new int[]{startIdx, endIdx};
            
        return ans;
    }
    
    private int findBinary(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end)/2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                end = mid-1;
            }
            else {
                start = mid + 1;
            }
        }
        
        return -1;
    }
}
