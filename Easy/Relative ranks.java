import java.util.Arrays;

public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[] nums_copy = nums.clone();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }

        String[] rank = {"Gold Medal", "Silver Medal", "Bronze Medal"};

        String[] ans = new String[nums.length];
        for (int i=0;i<nums.length;i++) {
            if (findIndex(nums,nums_copy[i]) == 0 || findIndex(nums,nums_copy[i]) == 1 || findIndex(nums,nums_copy[i]) == 2) {
                ans[i] = rank[findIndex(nums,nums_copy[i])];
            }
            else {
                ans[i] = String.valueOf(findIndex(nums,nums_copy[i]) + 1);
            }
        }
        return ans;
    }
    public int findIndex(int[] nums, int elem) {
        for (int i=0;i<nums.length;i++) {
            if (nums[i] == elem) {
                return i;
            }
        }
        return -1;
    }
}