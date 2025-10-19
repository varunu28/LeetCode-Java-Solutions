class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(k * i)) {
                return k * i;
            }
        }
        return k * (n + 1);
    }
}
