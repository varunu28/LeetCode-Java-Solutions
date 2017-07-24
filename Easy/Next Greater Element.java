public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] ans = new int[findNums.length];
        for (int i=0;i<findNums.length;i++) {
            ans[i] = -1;
        }
        for (int i=0;i<findNums.length;i++) {
            for (int k=indexOf(nums, findNums[i]);k<nums.length;k++) {
                if (nums[k] > findNums[i]) {
                    ans[i] = Math.max(nums[k], ans[i]);
                    break;
                }
            }
        }
        return ans;
    }
    
    public int indexOf(int[] arr, int n) {
        for (int i=0;i<arr.length;i++) {
            if (arr[i] == n) {
                return i;
            }
        }
        return -1;
    }
}