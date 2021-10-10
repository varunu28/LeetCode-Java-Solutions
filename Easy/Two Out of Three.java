class Solution {
  public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
    Map<Integer, Set<String>> map = new HashMap<>();
    updateMap(map, nums1, "1");
    updateMap(map, nums2, "2");
    updateMap(map, nums3, "3");
    return map.entrySet()
      .stream()
      .filter(entry -> entry.getValue().size() > 1)
      .map(entry -> entry.getKey())
      .collect(Collectors.toList());
  }
  
  private void updateMap(Map<Integer, Set<String>> map, int[] nums, String key) {
    for (int num : nums) {
      map.computeIfAbsent(num, k -> new HashSet<>()).add(key);
    }
  }
}
