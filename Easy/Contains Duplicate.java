class Solution {
  public boolean containsDuplicate(int[] nums) {
    return Arrays.stream(nums).boxed().collect(Collectors.toSet()).size() < nums.length;
  }
}
