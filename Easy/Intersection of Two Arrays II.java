class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    Map<Integer, Long> map = Arrays.stream(nums1).boxed()
        .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
    List<Integer> result = new ArrayList<>();
    for (int num : nums2) {
      if (map.getOrDefault(num, 0L) > 0) {
        result.add(num);
        map.put(num, map.get(num) - 1);
      }
    }
    return result.stream().mapToInt(Integer::valueOf).toArray();
  }
}
