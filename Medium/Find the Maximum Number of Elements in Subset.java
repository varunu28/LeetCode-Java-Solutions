class Solution {
    public int maximumLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = map.containsKey(1) ? (map.get(1) % 2 == 0 ? map.get(1) - 1 : map.get(1)) : 1;
        for (int num : nums) {
            int count = 0;
            while (map.containsKey(num) && map.get(num) >= 2 && num != 1) {
                count += 2;
                num *= num;
            }
            count += map.containsKey(num) ? 1 : -1;
            result = Math.max(result, count);
        }
        return result;
    }
}
