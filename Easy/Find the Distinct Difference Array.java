class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        int[] rightToLeft = new int[nums.length];
        Set<Integer> set = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            set.add(nums[i]);
            rightToLeft[i] = set.size();
        }
        int[] diff = new int[nums.length];
        set.clear();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            diff[i] = set.size() - (i == nums.length - 1 ? 0 : rightToLeft[i + 1]);
        }
        return diff;
    }
}
