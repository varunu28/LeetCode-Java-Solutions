class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i=0; i<nums.length; i++) {
            long num = nums[i];
            Long floor = treeSet.floor(num + t);
            Long ceil = treeSet.ceiling(num - t);

            if (floor != null && floor >= nums[i] ||
                ceil != null && ceil <= nums[i]) {
                return true;
            }

            treeSet.add(num);

            if (i >= k) {
                treeSet.remove((long) nums[i - k]);
            }
        }

        return false;
    }
}
