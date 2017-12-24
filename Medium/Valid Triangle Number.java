class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i=0;i<nums.length-2;i++) {
            int k = i+2;
            for (int j=i+1;j<nums.length-1 && nums[i] != 0; j++) {
                while(k < nums.length && nums[k] < nums[i] + nums[j]) 
                    k++;
                count += k-j-1;
            }
        }
        
        return count;
    }
}
