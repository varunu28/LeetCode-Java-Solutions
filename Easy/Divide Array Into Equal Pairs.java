class Solution {
  public boolean divideArray(int[] nums) {
    return Arrays.stream(nums)
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), HashMap::new, Collectors.counting()))
        .values().stream().allMatch(e -> e % 2 == 0);
  }
}
