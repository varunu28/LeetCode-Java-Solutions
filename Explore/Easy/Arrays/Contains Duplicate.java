class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> arr = new HashSet<>();
        
        for (int i=0;i<nums.length;i++) {
            arr.add(nums[i]);
        }
        
        return arr.size() != nums.length;
    }
}
