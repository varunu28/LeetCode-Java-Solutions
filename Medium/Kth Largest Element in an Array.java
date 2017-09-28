class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length;
        while (i<k) {
            i++;
            j--;
        }
        
        return nums[j];
    }
}
