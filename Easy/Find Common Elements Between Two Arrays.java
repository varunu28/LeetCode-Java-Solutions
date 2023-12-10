class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = buildFrequencyMap(nums1);
        Map<Integer, Integer> map2 = buildFrequencyMap(nums2);
        int[] result = new int[2];
        for (Integer key : map1.keySet()) {
            if (map2.containsKey(key)) {
                result[0] += map1.get(key);
            }
        }
        for (Integer key : map2.keySet()) {
            if (map1.containsKey(key)) {
                result[1] += map2.get(key);
            }
        }
        return result;
    }
    
    private static Map<Integer, Integer> buildFrequencyMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }
}
