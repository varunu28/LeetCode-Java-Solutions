class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                int target = -1 * (nums[i] + nums[j]);
                
                int idx = findBinary(nums, j+1, nums.length-1, target);
                
                if (idx != -1) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[idx]);
                    
                    set.add(temp);
                }
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>(); 
        ans.addAll(set);
        
        return ans;
    }
    
    private int findBinary(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end)/2;
            
            if(nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                end = mid-1;
            }
            else {
                start = mid + 1;
            }
        }
        
        return -1;
    }
}
