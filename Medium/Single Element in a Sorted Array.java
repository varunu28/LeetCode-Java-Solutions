class Solution {
    public int singleNonDuplicate(int[] nums) {
        boolean evenInd = true;
        for (int i=0;i<nums.length-1;i++) {
            if (nums[i] != nums[i+1] && evenInd) {
                return nums[i];
            }
            evenInd = evenInd ? false : true;
        }
        
        return nums[nums.length-1];
    }
}
