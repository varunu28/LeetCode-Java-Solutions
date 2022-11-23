class Solution {
    public boolean isConsecutive(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num - min >= nums.length || !set.add(num - min)) {
                return false;
            }
        }
        return true;
    }
}
