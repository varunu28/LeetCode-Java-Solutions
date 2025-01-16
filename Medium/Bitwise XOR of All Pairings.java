class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + n);
        }
        for (int num : nums2) {
            freq.put(num, freq.getOrDefault(num, 0) + m);
        }
        int result = 0;
        for (Integer key : freq.keySet()) {
            if (freq.get(key) % 2 == 1) {
                result ^= key;
            }
        }
        return result;
    }
}
