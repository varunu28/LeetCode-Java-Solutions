class Solution {
  public String kthLargestNumber(String[] nums, int k) {
    Arrays.sort(nums, (o1, o2) ->
        o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length());
    return nums[nums.length - k];
  }
}
