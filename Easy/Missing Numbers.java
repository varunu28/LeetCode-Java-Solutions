public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length > 1 && nums[0] == 0) {
            for (int i=0;i<nums.length-1;i++) {
                if (nums[i]-nums[i+1] != -1) {
                    return nums[i] + 1;
                }
            }
        }
        else {
            if (nums[0] == 0) {
                return nums[0] +1;
            }
            else {
                return 0;
            }
        }
        return nums[nums.length-1] + 1;
    }
}