class Solution {
    public int findMin(int[] nums) {
        int low = 0 ;
        int high = nums.length-1;
        while(low<high) {
            int mid = (low+high)/2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            }
            else if (nums[mid] < nums[high]) {
                high = mid;
            }
        }
        
        return nums[low];
    }
}
