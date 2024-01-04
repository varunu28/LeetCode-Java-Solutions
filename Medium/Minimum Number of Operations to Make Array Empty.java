class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int operations = 0;
        for (Integer value : map.values()) {
            if (value == 1) {
                return -1;
            }
            operations += value / 3 + (value % 3 == 0 ? 0 : 1);
        }
        return operations;
    }
}
