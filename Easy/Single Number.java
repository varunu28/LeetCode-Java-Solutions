public class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        boolean twice = true;
        for (int i=0;i<nums.length-1;i++) {
            if (nums[i] != nums[i+1]) {
                if (twice) {
                    twice = false;
                }
                else {
                    return nums[i];
                }
            }
            else {
                twice = true;
            }
        }
        return nums[nums.length-1];
    }
}