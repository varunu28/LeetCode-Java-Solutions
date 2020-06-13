class Solution {
  public List<Integer> largestDivisibleSubset(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return new ArrayList<>();
    }
    Map<Integer, List<Integer>> map = new HashMap<>();
    Arrays.sort(nums);
    List<Integer> maxSubset = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      List<Integer> subset = helper(i, map, nums);
      if (subset.size() > maxSubset.size()) {
        maxSubset = subset;
      }
    }
    return maxSubset;
  }
  
  private List<Integer> helper(int i, Map<Integer, List<Integer>> map, int[] nums) {
    if (map.containsKey(i)) {
      return map.get(i);
    }
    List<Integer> maxSubset = new ArrayList<>();
    for (int k = 0; k < i; k++) {
      if (nums[i] % nums[k] == 0) {
        List<Integer> subset = helper(k, map, nums);
        if (maxSubset.size() < subset.size()) {
          maxSubset = subset;
        }
      }
    }
    List<Integer> newEntry = new ArrayList<>();
    newEntry.addAll(maxSubset);
    newEntry.add(nums[i]);
    map.put(i, newEntry);
    return newEntry;
  }
}
