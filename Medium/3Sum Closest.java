class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        
        for (int i=0; i<nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            
            while (j < k) {
                int tempSum = nums[i] + nums[j] + nums[k];
                if (sum == Integer.MAX_VALUE || Math.abs(sum - target) > Math.abs(target - tempSum)) {
                    sum = tempSum;
                }
                
                if (tempSum > target) {
                    k--;
                }
                else {
                    j++;
                }    
            }
        }
        
        return sum;
    }
}
