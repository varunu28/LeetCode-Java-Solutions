class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i=0;i<nums.length-2;i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            
            int j = i+1;
            int k = nums.length-1;
            
            int target = -nums[i];
            
            while (j<k) {
                if (nums[j] + nums[k] == target) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                }
                else if (nums[j] + nums[k] > target) k--;
                else {
                    j++;
                }
            }
        }
        
        return ans;
    }
}
