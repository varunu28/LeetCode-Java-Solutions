class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(num));
        }
        int count = 0;
        for (int num : nums) {
            if (map.get(num) == maxFrequency) {
                count++;
            }
        }
        return count;
    }
}
