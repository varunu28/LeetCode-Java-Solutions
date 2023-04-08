class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            indexMap.putIfAbsent(nums2[i], i);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = indexMap.get(nums1[i]);
        }
        return result;
    }
}
