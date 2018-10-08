class Solution {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        permuteHelper(nums, new ArrayList<>(), ans, new boolean[nums.length]);
        return new ArrayList<>(ans);
    }

    private static void permuteHelper(int[] nums, List<Integer> list, List<List<Integer>> ans, boolean[] used) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
        }
        else {
            for (int i=0; i<nums.length; i++) {
                // Choose
                if (used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) {
                    continue;
                }

                used[i] = true;
                list.add(nums[i]);

                // Explore
                permuteHelper(nums, list, ans, used);

                // Un-choose
                used[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
