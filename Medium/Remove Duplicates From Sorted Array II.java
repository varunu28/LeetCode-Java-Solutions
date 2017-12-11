class Solution {
    public int removeDuplicates(int[] nums) {
        return removeDuplicatesUtil(nums, nums.length, 2);
    }
    
    private int removeDuplicatesUtil(int[] nums, int n, int k) {
        if (n <= k) return n;
        
        int i = 1;
        int j = 1;
        int cnt = 1;
        
        while (j < n) {
            if (nums[j] != nums[j-1]) {
                cnt = 1;
                nums[i++] = nums[j];
            }
            else {
                if (cnt < k) {
                    nums[i++] = nums[j];
                    cnt++;
                }
            }
            ++j;
        }
        
        return i;
    }
}
