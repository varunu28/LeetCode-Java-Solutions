class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int[] copy = new int[nums.length];
        for (int i=0;i<nums.length;i++) {
            copy[i] = nums[i];
        }
        
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length-1;
        int ans = 0;
        
        while(start<end) {
            if (nums[start] != copy[start] && nums[end] != copy[end]) {
                ans = end-start+1;
                break;
            }
            else if (nums[start] == copy[start] && nums[end] != copy[end]) {
                start++;
            }
            else if (nums[start] != copy[start] && nums[end] == copy[end]) {
                end--;
            }
            else if (nums[start] == copy[start] && nums[end] == copy[end]) {
                end--;
                start++;
            }
        }
        
        return ans;
    }
}
