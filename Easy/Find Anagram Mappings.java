class Solution {
  public int[] anagramMappings(int[] nums1, int[] nums2) {
    Map<Integer, Integer> indexMapping = new HashMap<>();
    for (int i = 0; i < nums2.length; i++) {
      indexMapping.put(nums2[i], i);
    }
    for (int i = 0; i < nums1.length; i++) {
      nums1[i] = indexMapping.get(nums1[i]);
    }
    return nums1;
  }
}
