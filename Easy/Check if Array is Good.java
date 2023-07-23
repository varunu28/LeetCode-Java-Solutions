class Solution {
    public boolean isGood(int[] nums) {
        if (nums.length <= 1) {
            return false;
        }
        int n = nums.length - 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i)) {
                return false;
            }
            if (map.get(i) > 1 && i != n) {
                return false;
            }
            if (i == n && map.get(i) != 2) {
                return false;
            }
        }
        return true;
    }
}
