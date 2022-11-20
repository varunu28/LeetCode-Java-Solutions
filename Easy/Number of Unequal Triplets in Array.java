class Solution {
    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        int left = 0;
        int right = nums.length;
        for (Integer key : map.keySet()) {
            right -= map.get(key);
            result += left * map.get(key) * right;
            left += map.get(key);
        }
        return result;
    }
}
