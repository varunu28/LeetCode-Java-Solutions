class Solution {
  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    Set<Integer> setOne = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
    Set<Integer> setTwo = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
    return Arrays.asList(
        setOne.stream().filter(e -> !setTwo.contains(e)).collect(Collectors.toList()),
        setTwo.stream().filter(e -> !setOne.contains(e)).collect(Collectors.toList()));
  }
}
