class Solution {
    public int minMoves2(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        int c = 0;
        
        Arrays.sort(nums);
        
        while (i < j) {
            c += nums[j] - nums[i];
            i++;
            j--;
        }
        
        return c;
    }
}
