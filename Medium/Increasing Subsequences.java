class Solution {
    Set<List<Integer>> ans;

    public List<List<Integer>> findSubsequences(int[] nums) {
        ans = new HashSet<>();
        helper(nums, 0, new ArrayList<>());

        return new ArrayList<>(ans);
    }

    private void helper(int[] nums, int start, List<Integer> list) {
        if (start == nums.length) {
            if (list.size() >= 2) {
                ans.add(new ArrayList<>(list));
                return;
            }
        }

        if (list.size() >= 2) {
            ans.add(new ArrayList<>(list));
        }

        for (int idx = start; idx < nums.length; idx++) {
            if (list.size() != 0 && nums[idx] < list.get(list.size() - 1)) {
                continue;
            }
            
            // Choose
            list.add(nums[idx]);

            // Explore
            helper(nums, idx + 1, list);

            // Un-choose
            list.remove(list.size() - 1);
        }
    }
}
