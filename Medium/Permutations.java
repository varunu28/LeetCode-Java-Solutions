class Solution {
    public List<List<Integer>> ans = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        permuteHelper(nums, list, 0);
        return ans;
    }

    private void permuteHelper(int[] nums, List<Integer> list, int idx) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
        }
        else {
            for (int i=0; i<nums.length; i++) {
                // Choose
                if (list.contains(nums[i])) {
                    continue;
                }
                list.add(nums[i]);

                // Explore
                permuteHelper(nums, list, i+1);

                // Un-choose
                list.remove(list.size()-1);
            }
        }
    }
}
