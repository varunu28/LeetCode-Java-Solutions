class Solution {
  public int minimumOperations(int[] nums) {
    return Arrays.stream(nums).boxed().filter(n -> n > 0).collect(Collectors.toSet()).size();
  }
}
