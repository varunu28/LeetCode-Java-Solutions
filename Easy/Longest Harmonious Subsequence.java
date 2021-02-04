class Solution {
  public int findLHS(int[] nums) {
    Map<Integer, Long> map = Arrays.stream(nums).boxed()
        .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()));
    int result = 0;
    for (Integer key : map.keySet()) {
      if (map.containsKey(key + 1)) {
        result = Math.max(result, (int) (map.get(key) + map.get(key + 1)));
      }
    }
    return result;
  }
}
